import { PokeDeck } from '../models/pokeDeck.model';
import { PokeDeckService } from './../services/poke-deck.service';
import { TrainerService } from './../services/trainer.service';
import { Trainer } from './../models/trainer';
import { ClientMessage } from './../models/client-message.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-trainer-deck',
  templateUrl: './trainer-deck.component.html',
  styleUrls: ['./trainer-deck.component.css']
})
export class TrainerDeckComponent implements OnInit {

  trainerDeck:PokeDeck[] = [];
  trainer:Trainer = new Trainer(0, '', '', '', '');
  clientMessage: ClientMessage = new ClientMessage('No pokeDeck to display');

  constructor(private trainerService: TrainerService, private pokeDeckService: PokeDeckService) { }
 
  ngOnInit(): void {
    this.getTrainer();
    this.getTrainerPokeDeck();
  }

  getTrainer(){
    this.trainerService.findTrainer(this.trainer).subscribe(data => this.trainer = data)
  }

  getTrainerPokeDeck(){
    this.pokeDeckService.findPokeDeckByTrainerId(this.trainerDeck[0]).subscribe(data => this.trainerDeck = data)
  }


}
