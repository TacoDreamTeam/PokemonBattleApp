import { PokeDeckService } from './../services/poke-deck.service';
import { PokeDeck } from './../models/pokeDeck.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-poke-deck',
  templateUrl: './poke-deck.component.html',
  styleUrls: ['./poke-deck.component.css']
})
export class PokeDeckComponent implements OnInit {

  public pokeDeck: PokeDeck[] = [];

  constructor(private pokeDeckService: PokeDeckService) { }

  ngOnInit(): void {
    this.findPokeDeck();
  }

  public findPokeDeck(){
    this.pokeDeckService.findAllPokeDeck().subscribe(data => this.pokeDeck = data)
  }
}
