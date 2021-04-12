import { HttpClient } from '@angular/common/http';
import { PokemonAPI } from './../models/pokemonApi';
import { Router } from '@angular/router';

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

  sessionValue:any='';
  currentUser:any;
  user: any;
  name: any;
  deck:PokeDeck = new PokeDeck(0, 0, 0);

  pokemon: PokemonAPI = new PokemonAPI(0, '', 0, 0 , '', '', 0, 0, 0 ,0, 0, 0);
  allPokemon: PokemonAPI[] = [];
  
  recievedDecks: PokeDeck[] = [];
  allDecks: PokeDeck[] = [];

  clientMessage: ClientMessage = new ClientMessage('No pokeDeck to display');

  constructor(private pokeDeckService: PokeDeckService, private router: Router, private http: HttpClient) { }
 
  ngOnInit(): void {
    this.sessionValue=sessionStorage.getItem("currentTrainer");
    this.checkForUser();

    this.deck.trainerId = this.currentUser.trainerId;
    console.log(this.currentUser.trainerId);
    this.findTrainerDeck();
    // this.findAll();

    console.log(this.recievedDecks);
    // console.log(this.allDecks);
  }

checkForUser(){
  if(this.currentUser===null){
    console.log("No user detected")
    this.router.navigate(['login'])
  }else{
    this.currentUser=JSON.parse(this.sessionValue);
    console.log(this.currentUser);
  }
}
  findTrainerDeck():void{
    this.pokeDeckService.findPokeDeckByTrainerId(this.deck).subscribe((data) => { 
      
      this.recievedDecks = JSON.parse(JSON.stringify(data));

      for(let i = 0; i< this.recievedDecks.length; i++){
        this.gettingPokemon(this.recievedDecks[i].pokemonId)
      }

    });


    
  }

  findAll(): void{
    this.pokeDeckService.findAllPokeDeck().subscribe((data) =>{ this.allDecks = data; 
      let value:any;
      value=data;
      console.log(data.toString())
      console.log(JSON.stringify(data));
      console.log(JSON.parse(JSON.stringify(data)));
      this.allDecks = JSON.parse(JSON.stringify(data));
      })

  }

  gettingPokemon(api: number) {
    const url=`https://pokeapi.co/api/v2/pokemon/${api}`;
      this.http.get(url).subscribe((res)=>{
        let poke:any
        poke=res
        let name=poke.name
        let front=poke.sprites.front_default
        let back=poke.sprites.back_default
        let type=poke.types[0].type.name
        let atkName=poke.moves[0].move.name//attack name
        let hp=poke.stats[0].base_stat //hp
        let atk=poke.stats[1].base_stat//attack
        let def=poke.stats[2].base_stat//defense
        let spAtk=poke.stats[3].base_stat//special-attack
        let spDef=poke.stats[4].base_stat//special-defense
        let spd=poke.stats[5].base_stat//speed
        let pokemon=new PokemonAPI(api, name, front, back, type, 
                                     atkName, hp, atk, def, 
                                     spAtk, spDef, spd);
        console.log(pokemon.name);
        this.allPokemon.push(pokemon);    })}
  }

  
