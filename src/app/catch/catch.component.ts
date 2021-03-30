import { Trainer } from './../models/trainer';
import { Team } from './../models/team.model';
import { ClientMessage } from './../models/client-message.model';
import { pokeDex } from './../models/pokeDex';
import { PokemonAPI } from './../models/pokemonApi';
import { TypeService } from './../services/type.service';
import { Type } from './../models/type';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { PokemonService } from './../services/pokemon.service';
import { MessageService } from './../services/message.service';
import { TeamService } from './../services/team.service';
import { Component, OnInit } from '@angular/core';
import {catchError} from 'rxjs/operators'

@Component({
  selector: 'app-catch',
  templateUrl: './catch.component.html',
  styleUrls: ['./catch.component.css']
})
export class CatchComponent implements OnInit {

  httpOptions={
    headers:new HttpHeaders({'Content-Type':'application/json'})
  }

  constructor(private teamService:TeamService, private pokemonService:PokemonService, private messageService: MessageService, private http:HttpClient, private typeService: TypeService) { }

  //header?
  title="Battle";

  public readyForBattle:boolean=false;
  public Battling:boolean=false;

  public currentTrainer?:Trainer;
//battles are currently hard coded in, retrieve from elsewhere later.
  public trainer1:Team=new Team(703, 1, 0, 0, 0, 0, 0);
  //public trainer2:Team=new Team(0, 1, 0, 0, 0, 0, 0); //set the first value to from precatch

  public team1?:Team; //=new Team(0, 0, 5, 0, 0, 0, 0, 0);
  public team2:Team=new Team(0, 0, 0, 0, 0, 0, 0); //set the first value to from precatch; //=new Team(0, 0, 0, 0, 0, 0, 0, 0);
  

  public pokemonTeam1: PokemonAPI[] = [];
  public pokemonTeam2: PokemonAPI[] = [];

  public effectiveness1:any[]=[];
  public effectiveness2:any[]=[];



  public battlePokemon1:PokemonAPI=new PokemonAPI(0, "", "", "", "", "", 0, 0, 0, 0, 0, 0);
  public battlePokemon2:PokemonAPI=new PokemonAPI(0, "", "", "", "", "", 0, 0, 0, 0, 0, 0);

  public clientMessage:ClientMessage=new ClientMessage('');

  ngOnInit(): void {
    //Get the teams from the trainer
    this.readyForBattle=false;
    this.Battling=false;

    //set current trainer team:
    let me: any;
    me=sessionStorage.getItem('currentTrainer')
    let currentTrainer:Trainer

    currentTrainer=JSON.parse(me);
    console.log(currentTrainer.teamId);
    this.currentTrainer=currentTrainer;
    this.trainer1.id=this.currentTrainer.teamId;  
    
    
    //set wild pokemon:
    let pokeID:any;
    pokeID=localStorage.getItem('wild');
    this.team2.pokemonId1=parseInt(JSON.parse(pokeID));
    

    this.teamService.findTeam(this.trainer1).subscribe((data) =>
      {this.team1=data;
        //get Pokemon from team1 info 
        this.getPokemon(this.team1.pokemonId1, this.pokemonTeam1);
        // this.getPokemon(this.team1.pokemonId2, this.pokemonTeam1);
        // this.getPokemon(this.team1.pokemonId3, this.pokemonTeam1);
        // this.getPokemon(this.team1.pokemonId4, this.pokemonTeam1);
        // this.getPokemon(this.team1.pokemonId5, this.pokemonTeam1);
        // this.getPokemon(this.team1.pokemonId6, this.pokemonTeam1);
        // //console.log(this.team1.pokemonId1)
      });


      //switch when import from storage

    this.getPokemon(this.team2.pokemonId1, this.pokemonTeam2);
    //this.teamService.findTeam(this.trainer2).subscribe((data) =>{
      // this.team2=data
      // //get Pokemon from team2 info 
      // this.getPokemon(this.team2.pokemonId1, this.pokemonTeam2);
      // // this.getPokemon(this.team2.pokemonId2, this.pokemonTeam2);
      // this.getPokemon(this.team2.pokemonId3, this.pokemonTeam2);
      // this.getPokemon(this.team2.pokemonId4, this.pokemonTeam2);
      // this.getPokemon(this.team2.pokemonId5, this.pokemonTeam2);
      // this.getPokemon(this.team2.pokemonId6, this.pokemonTeam2);
      // //console.log(this.team2.pokemonId1)
    //}); 
      
      //decide winner of round, advance to next pokemon of team that lost round

    //declare winner

  }

  getPokemon(id:number, team:any[]){
    console.log("passed through number is: ");
    console.log(id); 
    // if (id>0){
    // const url=`https://pokeapi.co/api/v2/pokemon/${id}`;
    // this.http.get(url).subscribe((res)=>{
    //   team.push(res);
    //   //console.log(res.name);
    // })}
    // let pokemon=this.pokemonService.getPokemonByID(id);
    // console.log(`pokemon id: ${id}`);
    // console.log(pokemon);
    // team.push(pokemon);

    //generates Cors error
    // this.pokemonService.getPokemonByID(id).subscribe((res) =>{
    //     let poke:any
    //     poke=res
        
    //     let name=poke.name
    //     let front=poke.sprites.front_default
    //     let back=poke.sprites.back_default
    //     let type=poke.types[0].type.name
    //     let atkName=poke.moves[0].move.name//attack name
    //     let hp=poke.stats[0].base_stat //hp
    //     let atk=poke.stats[1].base_stat//attack
    //     let def=poke.stats[2].base_stat//defense
    //     let spAtk=poke.stats[3].base_stat//special-attack
    //     let spDef=poke.stats[4].base_stat//special-defense
    //     let spd=poke.stats[5].base_stat//speed
         
    //     let pokemon=new PokemonAPI(id, name, front, back, type, 
    //                                  atkName, hp, atk, def, 
    //                                  spAtk, spDef, spd);
    //     console.log(pokemon.name);
    //     team.push(pokemon);    })}
    // console.log(`pokemon id: ${id}`);
    // console.log(pokemon);
    // team.push(pokemon);


    //I know that this should be a service call instead, but if I call the service (that this is copied and pased from), values don't load so.....
    if (id>0){    
      const url=`https://pokeapi.co/api/v2/pokemon/${id}`;
      this.http.get(url).subscribe((res)=>{
        let poke:any
        poke=res
        
        let name=poke.name
        let front=poke.sprites.front_default
        let back=poke.sprites.back_default
        let type=poke.types[0].type.name
        //let atkName=poke.moves[0].move.name//attack name
        let atkName=poke.abilities[0].ability.name//attack name
        let hp=poke.stats[0].base_stat //hp
        let atk=poke.stats[1].base_stat//attack
        let def=poke.stats[2].base_stat//defense
        let spAtk=poke.stats[3].base_stat//special-attack
        let spDef=poke.stats[4].base_stat//special-defense
        let spd=poke.stats[5].base_stat//speed
         
        let pokemon=new PokemonAPI(id, name, front, back, type, 
                                     atkName, hp, atk, def, 
                                     spAtk, spDef, spd);
        console.log(pokemon.name);
        team.push(pokemon);    })}
  }

  prepareForBattle():void{
    console.log(`team1: ${this.pokemonTeam1.length}, team2: ${this.pokemonTeam2.length}`)
    for (let i=0; i<this.pokemonTeam1.length; i++){
      this.effectiveness1[i]=[];
      this.effectiveness2[i]=[];
      for (let j=0; j<this.pokemonTeam2.length; j++){
          this.effectiveness1[i][j]=0;
          this.effectiveness2[i][j]=0;
        }
      }

    console.log(`effectiveness1 matrix: ${this.effectiveness1}`);
    console.log(`effectiveness2 matrix: ${this.effectiveness2}`);

    for (let i=0; i<this.pokemonTeam1.length; i++){
      // console.log(this.pokemonTeam1[i].name)
      // console.log(this.pokemonTeam1[i].type)
      this.effectiveness1[i]=[];
      this.effectiveness2[i]=[];
      for (let j=0; j<this.pokemonTeam2.length; j++){
        // console.log(this.pokemonTeam2[j].name)
        // console.log(this.pokemonTeam2[j].type)
        this.typeService.getEffectiveness(this.pokemonTeam1[i].type, this.pokemonTeam2[j].type).subscribe((result) =>{
          console.log(`i: ${i}, j: ${j}, result: ${result}`);
          this.effectiveness1[i][j]=result ;
        });

        this.typeService.getEffectiveness(this.pokemonTeam2[j].type, this.pokemonTeam1[i].type).subscribe((result) =>{
          console.log(`i: ${i}, j: ${j}, result: ${result}`);
          this.effectiveness2[i][j]=result ;
        });

      }
    }
    console.log(`effectiveness1: ${this.effectiveness1}`);
    console.log(`effectiveness2: ${this.effectiveness2}`);
    this.readyForBattle=true;
    this.Battling=false;
  }
  
  //a check
  geteffectivness(){
    console.log(`effectiveness1: ${this.effectiveness1}`);
    console.log(`effectiveness2: ${this.effectiveness2}`);

  }

  public winner?:string;
  public round?:string;
  Battle():void{
    this.readyForBattle=true;
    this.Battling=true;
    this.winner="";

    let p1=0 //pokemon Team 1 is using
    let p2=0 //pokemon Team 2 is using
    let dPower1=0 //defensive power of pokemon Team 1 is using
    let dPower2=0 //defensive power of pokemon Team 2 is using
    let aPower1=0 //attack power of pokemon Team 1 is using
    let aPower2=0 //attack power of pokemon Team 2 is using

    let results=[[p1, p2, "start"]]

    this.battlePokemon1=this.pokemonTeam1[p1];
    this.battlePokemon2=this.pokemonTeam2[p2];
  

    while (p1<this.pokemonTeam1.length && p2<this.pokemonTeam2.length){
      this.battlePokemon1=this.pokemonTeam1[p1];
      this.battlePokemon2=this.pokemonTeam2[p2];

      //get defensive power
      dPower1=this.battlePokemon1.health*(this.battlePokemon1.defense+this.battlePokemon1.spDefense);
      dPower2=this.battlePokemon2.health*(this.battlePokemon2.defense+this.battlePokemon2.spDefense);

      //get offensive power
      aPower1=this.battlePokemon1.attack+this.battlePokemon1.spAttack*this.effectiveness1[p1][p2];
      aPower2=this.battlePokemon2.attack+this.battlePokemon2.spAttack*this.effectiveness2[p1][p2];

      //find out which pokemon has the greater amount of power
      if ((dPower1/aPower2)>(dPower2/aPower1)){
        p2+=1;
        results.push([p1, p2, `team 1 won this round, power1 ratio: ${dPower1/aPower2}, power2 ratio ${dPower2/aPower1}`])
      }else if((dPower1/aPower2)<(dPower2/aPower1)){
        p1+=1;
        results.push([p1, p2, `team 2 won this round, power1 ratio: ${dPower1/aPower2}, power2 ratio ${dPower2/aPower1}`])

      }else{
        //tie so use random chance
        let rnd=Math.random();
        
        if (rnd<0.5){
          p2+=1
          results.push([p1, p2, `tie, team 1 won this round, power1 ratio: ${dPower1/aPower2}, power2 ratio ${dPower2/aPower1}`])
        }else{
          p1+=1
          results.push([p1, p2, `tie, team 1 won this round, power1 ratio: ${dPower1/aPower2}, power2 ratio ${dPower2/aPower1}`])
        }
      }
    }


    // https://medium.com/dev-genius/how-to-make-javascript-sleep-or-wait-d95d33c99909
    // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/await
    let i=results.length-1;
    for (let j=0; j<i; j++){
      setTimeout(()=>
        this.battlePokemon1=this.pokemonTeam1[results[j][0]], 1000*j);
      setTimeout(()=>
        this.battlePokemon2=this.pokemonTeam2[results[j][1]], 1000*j);
      setTimeout(()=>
        console.log(results[j][2].toString()), 1000*j);
      setTimeout(()=>
        this.round=(results[j][2].toString()), 1000*j);
    }

    if (p1==this.pokemonTeam1.length){
      setTimeout(()=>
        this.winner=`You have lost the battle, and ${this.pokemonTeam2[0].name} has run away`, 1000*i);            
    }else{
      //change user number to get from local storage
      let poke=new pokeDex(this.currentTrainer?.trainerId, this.pokemonTeam2[0].id);
      
      let result:any;
      this.registerPokemon(poke).subscribe(data => this.clientMessage=data, 
        error => this.clientMessage.message='something went wrong');
      //result=this.http.post<pokeDex>(`http://localhost:8080/PokemonBattleApp/PokeDeckInsert`, poke);
      //console.log(`result: ${result.message}`);
      setTimeout(()=>
        this.winner=`You have won the battle, and caught ${this.pokemonTeam2[0].name}, ${this.pokemonTeam2[0].id}`, 1000*i);
          //move to service once merged.       
    }

    setTimeout(()=>
          window.location.href="http://localhost:4200/trainerDash", 1000*(i+2));

  }

  public registerPokemon(poke:pokeDex):Observable<ClientMessage>{
    //this will return a client message if we are successfully able to POST a hero to our server
    console.log('trying to register pokemon')
    let URL=`http://localhost:8080/PokemonBattleApp/PokeDeckInsert`
    return this.http.post<ClientMessage>(URL, poke, this.httpOptions)   //adding this.httpOptions just constructs a more robust post request to our server.  We are asking our server to return it as JSON.
      .pipe(
        catchError(this.handleError<any>('cannot register hero!'))
      )
  }

  private handleError<T>(operation='operation', result?:T){
    return (error: any): Observable<T>=>{
      console.error(error); //log error to the console if something goes wrong
      
      //Let the app keep runing by returing an empty result.
      return of(result as T);
    }

  }

}
