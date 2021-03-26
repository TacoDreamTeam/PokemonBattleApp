import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Trainer } from '../models/trainer';
import { TrainerService } from './../services/trainer.service';
import { PokeDeckService } from './../services/poke-deck.service';
import { PokeDeck } from '../models/pokeDeck.model';

@Component({
  selector: 'app-trainer-trades',
  templateUrl: './trainer-trades.component.html',
  styleUrls: ['./trainer-trades.component.css']
})
export class TrainerTradesComponent implements OnInit {

  constructor(private fb: FormBuilder, private trainerService: TrainerService, private pokeDeckService: PokeDeckService) { }

  ngOnInit(): void {
    this.findAllTrainersFromService();
    this.findAllPokeDeckFromService();
    this.tempPokeDeck = this.pokeDeck;
  }
  
  tradeForm = this.fb.group({
    OtherTrainer:[''],
    OtherPokemon:[''],
    OwnPokemon:['']
  });

  trainer:Trainer[] = []
  tempPokeDeck:PokeDeck[] = []
  pokeDeck:PokeDeck[] = []
  otherTrainerId: number = 0;

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.tradeForm.value);
  }

  public findAllTrainersFromService(): void {
    // in this method we call on our service to fetch the heroes array and set it equal to 
    // our heroes property
    this.trainerService.findAllTrainer().subscribe(data => this.trainer = data);
  }

  public findAllPokeDeckFromService(): void {
    this.pokeDeckService.findAllPokeDeck().subscribe(data => this.pokeDeck = data);
  }

  public findAllPokeDeckByIdFromService(): void {
    let temp = new PokeDeck(0,this.otherTrainerId,0);
    console.log("SELECTED VALUE: " + temp);
    this.pokeDeckService.findPokeDeckById(temp).subscribe(data => this.pokeDeck = data);
  }

  searchPokeDeck(event: any) {
    this.otherTrainerId = event.target.value;
    this.findAllPokeDeckByIdFromService();
  }
}
