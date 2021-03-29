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
  }
  
  tradeForm = this.fb.group({
    OtherTrainer:[''],
    OtherPokemon:[''],
    OwnPokemon:['']
  });

  trainer:Trainer[] = [];
  pokeDeck:PokeDeck [] = [];
  myPokeDeck: PokeDeck [] = [];
  
  public user: Trainer = new Trainer(0,"","","","");
  public dex: PokeDeck = new PokeDeck(0,0,0);

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.tradeForm.value);
  }

  public findAllTrainersFromService(): void {
    // in this method we call on our service to fetch the trainer array and set it equal to 
    // our trainer property
    this.trainerService.findAllTrainer().subscribe(data => this.trainer = data);
  }

  public findAllPokeDeckFromService(): void {
    this.pokeDeckService.findAllPokeDeck().subscribe(data => this.pokeDeck = data);
  }

  public findAllPokeDeckByTrainerIdFromService(): void {
    console.log("SELECTED VALUE: " + this.dex.trainerId);
    this.pokeDeckService.findPokeDeckByTrainerId(this.dex).subscribe(data => this.pokeDeck = data);
  }

  searchPokeDeck(event: any) {
    this.dex = new PokeDeck(0,event.target.value,0);
    this.findAllPokeDeckByTrainerIdFromService();
  }
}
