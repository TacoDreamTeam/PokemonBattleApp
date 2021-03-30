import { catchError } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { from, Observable, of } from 'rxjs';
import { MessageService } from '../services/message.service';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http:HttpClient,private messageService: MessageService) { }

 getPokemon(){
   return this.http.get(`https://pokeapi.co/api/v2/pokemon?limit=200`)
 }

getMoreData(name:string){
  return this.http.get(`https://pokeapi.co/api/v2/pokemon/${name}`)
}


// pokemon:PokemonAPI=new PokemonAPI(0, "", "", "", "", "", 0, 0, 0, 0, 0, 0);
getPokemonByID(id:number):Observable<any>{
  return this.http.post<any>(`https://pokeapi.co/api/v2/pokemon/${id}`, id)
    .pipe(
      catchError(this.handleError<any>('findTeam', undefined))
    )
}
//  getPokemonByID(id:number):PokemonAPI{
//   //return this.http.get(`https://pokeapi.co/api/v2/pokemon/${id}`)
//   //let id=parseInt(idString);
//   //pokemon?:Observable<PokemonAPI>

//   console.log(id);
//   if (id>0){    
//     const url=`https://pokeapi.co/api/v2/pokemon/${id}`;
//     this.http.get(url).subscribe((res)=>{
//       let poke:any
//       poke=res
//       // console.log(poke);
//       // console.log(poke.name)
//       // console.log(poke.moves[0].move.name)//attack name
//       // console.log(poke.types[0].type.name)
//       // console.log(poke.stats[0].base_stat)//hp
//       // console.log(poke.stats[1].base_stat)//attack
//       // console.log(poke.stats[2].base_stat)//defense
//       // console.log(poke.stats[3].base_stat)//special-attack
//       // console.log(poke.stats[4].base_stat)//special-defense
//       // console.log(poke.stats[5].base_stat)//speed
//       // console.log(poke.sprites.front_default)
//       // console.log(poke.sprites.back_default)

//       //let pokemon:PokemonAPI;
//       //console.log(poke);
//       let name=poke.name
//       let front=poke.sprites.front_default
//       let back=poke.sprites.back_default
//       let type=poke.types[0].type.name
//       let atkName=poke.moves[0].move.name//attack name
//       let hp=poke.stats[0].base_stat //hp
//       let atk=poke.stats[1].base_stat//attack
//       let def=poke.stats[2].base_stat//defense
//       let spAtk=poke.stats[3].base_stat//special-attack
//       let spDef=poke.stats[4].base_stat//special-defense
//       let spd=poke.stats[5].base_stat//speed
       
//       this.pokemon=new PokemonAPI(id, name, front, back, type, 
//                                    atkName, hp, atk, def, 
//                                    spAtk, spDef, spd);
//       console.log(this.pokemon);
//       //return(pokemon);
//     })}
//     return(this.pokemon);
//  }

getStartThree(){
  return this.http.get(`https://pokeapi.co/api/v2/pokemon?limit=3&offset=4.`)
}

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  /** Log a HeroService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`PokemonService: ${message}`);
  }
}
