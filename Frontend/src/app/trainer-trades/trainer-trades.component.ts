import { Trades } from './../models/trades.model';
import { TradesService } from './../services/trades.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Trainer } from '../models/trainer';
import { TrainerService } from './../services/trainer.service';
import { PokeDeckService } from './../services/poke-deck.service';
import { PokeDeck } from '../models/pokeDeck.model';
import { Router } from '@angular/router';
import { ClientMessage } from '../models/client-message.model';

@Component({
  selector: 'app-trainer-trades',
  templateUrl: './trainer-trades.component.html',
  styleUrls: ['./trainer-trades.component.css']
})
export class TrainerTradesComponent implements OnInit {

  constructor(private fb: FormBuilder, private trainerService: TrainerService, private pokeDeckService: PokeDeckService, private router: Router,
    private tradesService: TradesService) { }

  ngOnInit(): void {
    this.sessionValue=sessionStorage.getItem("currentTrainer");
    this.checkForUser();

    this.findAllTrainersFromService();
    this.findAllTradesFromService();
    this.findAllPokeDeckByTrainerIdFromService(new PokeDeck(0,this.currentUser.trainerId,0));
  }
  
  tradeForm = this.fb.group({
    OtherTrainer:[''],
    OtherPokemon:[''],
    OwnPokemon:['']
  });

  sessionValue:any='';
  currentUser:any;
  public clientMessage: ClientMessage = new ClientMessage('');

  trainer:Trainer[] = [];
  pokeDeck:PokeDeck []= [];
  myPokeDeck: PokeDeck [] = [];

  public user: Trainer = new Trainer(0,"","","","", 0);
  public dex: PokeDeck = new PokeDeck(0,0,0);

  public pokeDeck2: PokeDeck = new PokeDeck(0,0,0);

  allTrades: Trades [] = [];
  trade: Trades = new Trades(0,0,0,0,0,"Pending");

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.tradeForm.value);
  }

  public findAllTrainersFromService(): void {
    // in this method we call on our service to fetch the trainer array and set it equal to 
    // our trainer property
    this.trainerService.findAllTrainer().subscribe((data) => {
      this.trainer = data}
    )}

  public findAllPokeDeckByOtherTrainerIdFromService(): void {
    console.log("SELECTED VALUE: " + this.dex.trainerId);
    this.pokeDeckService.findPokeDeckByTrainerId(this.dex).subscribe(data => this.pokeDeck = data);
  }

  public findAllPokeDeckByTrainerIdFromService(pokeDeck: PokeDeck): void {
    console.log("SELECTED VALUE: " + pokeDeck.trainerId);
    this.pokeDeckService.findPokeDeckByTrainerId(pokeDeck).subscribe(data => this.myPokeDeck = data);
  }

  searchPokeDeck(event: any) {
    this.dex = new PokeDeck(0,event.target.value,0);
    this.findAllPokeDeckByOtherTrainerIdFromService();
  }

  checkForUser(){
    if(this.currentUser===null){
      console.log("No user detected")
      this.router.navigate(['login'])
    }else{
      this.currentUser=JSON.parse(this.sessionValue);
      console.log(this.currentUser);
      this.trade.hasPokeId = this.currentUser.trainerId;
    }
  }

  public findAllTradesFromService(): void {
    console.log("trades grabbed");
    this.tradesService.findAllTrades().subscribe(
      data => this.allTrades = data);
  }

  public registerTradeFromService(): void {
    console.log("trade registered");
    console.log(this.trade);

    this.tradesService.registerTrade(this.trade)
    .subscribe((data)=>(this.clientMessage=data),
    (error)=>(this.clientMessage.message)='The trade was unsuccessful'),
    this.findAllTradesFromService()
  }

  public updateTradeFromService(tradeComplete: Trades): void {
    this.tradesService.updateTrade(tradeComplete)
    .subscribe((data)=>
    (error)=>(this.clientMessage.message)='The trade failed to update')
  }


  public getPokeDeckByIdFromService(pokeDeck1: PokeDeck) {
    this.pokeDeckService.findPokeDeckById(pokeDeck1)
    .subscribe((data) => {(this.pokeDeck2 = data);
      this.switchTrainer(pokeDeck1.trainerId)})
  }

  public switchTrainer(trainId: number): void {
    this.pokeDeck2.trainerId = trainId;
    this.updatePokeDeckFromService(this.pokeDeck2);
  }

  public updatePokeDeckFromService(transition: PokeDeck): void {
    this.pokeDeckService.updatePokeDeck(transition)
    .subscribe((data)=>
    (error)=>(this.clientMessage.message)='The pokeDeck failed to update')
  }

  public tradeStatusAccept(index: number): void {
    let curTrade = this.allTrades[index];
    curTrade.status = "Accept";
    this.updateTradeFromService(curTrade);
    this.getPokeDeckByIdFromService(new PokeDeck(curTrade.pokemonWanted, curTrade.hasPokeId,0))
    this.getPokeDeckByIdFromService(new PokeDeck(curTrade.pokemonHas, curTrade.wantsPokeId, 0))
  }

  public tradeStatusDeny(index: number): void {
    this.allTrades[index].status = "Denied";
    this.updateTradeFromService(this.allTrades[index]);
  }


}
