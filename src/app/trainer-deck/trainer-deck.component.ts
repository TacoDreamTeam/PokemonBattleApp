
import { PokeDeckService } from './../services/poke-deck.service';
import { TrainerService } from './../services/trainer.service';
import { Trainer } from './../models/trainer';
import { ClientMessage } from './../models/client-message.model';
import { Component, OnInit } from '@angular/core';
import { PokeDeck } from '../models/pokeDeck.model';

@Component({
  selector: 'app-trainer-deck',
  templateUrl: './trainer-deck.component.html',
  styleUrls: ['./trainer-deck.component.css']
})
export class TrainerDeckComponent implements OnInit {

  

  deck: PokeDeck = new PokeDeck(0, 0, 0);
  recievedDecks: PokeDeck[] = [];

  clientMessage: ClientMessage = new ClientMessage('No pokeDeck to display');

  constructor(private trainerService: TrainerService, private pokeDeckService: PokeDeckService) { }
 
  ngOnInit(): void {
  }

  findTrainerDeck():void{
    this.pokeDeckService.findPokeDeckByTrainerId(this.deck).subscribe(data => this.recievedDecks = data)
  }
}
