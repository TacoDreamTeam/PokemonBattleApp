import { Component, OnInit } from '@angular/core';
import {ErrorStateMatcher} from '@angular/material/core';
import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import { AuthorizeService } from '../services/authorize.service';
import { Trainer } from '../models/trainer';
import { ClientMessage } from '../models/client-message.model';
import { TrainerService } from '../services/trainer.service';
import { PokeDeckService } from '../services/poke-deck.service';
import { PokemonService } from '../services/pokemon.service';
import { Pokemon } from '../models/pokemon.model';
import { PokeDeck } from '../models/pokeDeck.model';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {



  constructor(
    private authService: AuthorizeService,
    private router:Router,
    private formBuilder:FormBuilder,
    private trainerService: TrainerService,
    private pokemonService: PokemonService ) { }

    pokemons: any[] = [];
    trainers: any[]=[];

  profileForm = this.formBuilder.group({
    pokeApi: ['', Validators.required],
    name: [''],
    type:['']
  });

  ngOnInit(): void {
    this.getStartThree();
  }

  public trainer: Trainer = new Trainer(0, '', '', '','');

  public pokeDeck:PokeDeck = new PokeDeck(0,0,0)


  // Client message to the user
  public clientMessage: ClientMessage = new ClientMessage('');

  public registerTrainerFromService(): void {

    this.trainerService.registerTrainer(this.trainer).subscribe(data => this.clientMessage = data,

      error => this.clientMessage.message = 'SOMETHING WENT WRONG!');

  }

  public registerTrainerNewPokemon(): void {
    this.trainerService.registerNewTrainerPokemon(this.pokeDeck).subscribe(data => this.clientMessage = data,

      error => this.clientMessage.message = 'SOMETHING WENT WRONG!');

  }

  getAllTrainers():void{
    this.trainerService.findAllTrainer().subscribe(data => this.trainers = data)
    console.log(this.trainers)
  }

  public selectedPokemon1():void{
    this.profileForm.patchValue({
      pokeApi: 3,
      name:'CHARMELEON',
      type:'Fire'
    });
  }

  public selectedPokemon2():void{
    this.profileForm.patchValue({
      pokeApi: 5,
      name:'CHARIZARD',
      type:'Fire'
    });
  }

  public selectedPokemon3():void{
    this.profileForm.patchValue({
      pokeApi:7,
      name:'SQUIRTLE',
      type:'Water'
    });
  }



  getStartThree(): void {
    this.pokemonService.getStartThree().subscribe((res: any) => {
      res.results.forEach((data) => {
        this.pokemonService.getMoreData(data.name).subscribe((uniqRes: any) => {
          this.pokemons.push(uniqRes);
          console.log(this.pokemons);
        });
      });
    });
  }
}
