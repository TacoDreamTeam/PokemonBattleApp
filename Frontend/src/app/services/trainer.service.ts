import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Trainer } from './../models/trainer';
import { Observable, of } from 'rxjs';
import { POKEMON_URL } from './../../environments/environment';
import { ClientMessage } from './../models/client-message.model';
import { catchError } from 'rxjs/operators';
import { PokeDeck } from '../models/pokeDeck.model';
import { Team } from '../models/team.model';

@Injectable({
  providedIn: 'root'
})
export class TrainerService {
  findHero(trainer: Trainer) {
    throw new Error('Method not implemented.');
  }

  httpOptions = {
    // Shout out to Farid for figuring out that Content-Type must have a "-" if used
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  }

  constructor(private http: HttpClient) { }

  /*
  * POST
  */
  public registerTrainer(trainer: Trainer): Observable<ClientMessage>  {
    // this will return a client message if we are successfully able to POST a hero to our server
    return this.http.post<ClientMessage>(`${POKEMON_URL}TrainerInsert`, trainer, this.httpOptions)
                                                                      // adding httpOptions just constructs a more robust
                                                                      // post request to our server.  We are asking our
                                                                      // server to return it as JSON.
    .pipe(
      catchError(this.handleError<any>('cannot register Trainer!'))
    )
  }


/*
  * POST
  */
  public registerNewTrainerPokemon(pokeDeck: PokeDeck): Observable<ClientMessage>  {
    // this will return a client message if we are successfully able to POST a hero to our server
    return this.http.post<ClientMessage>(`${POKEMON_URL}PokeDeckInsert`, pokeDeck, this.httpOptions)
                                                                      // adding httpOptions just constructs a more robust
                                                                      // post request to our server.  We are asking our
                                                                      // server to return it as JSON.
    .pipe(
      catchError(this.handleError<any>('cannot register Trainer!'))
    )
  }

  public registerNewTeam(team: Team): Observable<ClientMessage>  {
    // this will return a client message if we are successfully able to POST a hero to our server
    return this.http.post<ClientMessage>(`${POKEMON_URL}TrainerInsert`, team, this.httpOptions)
                                                                      // adding httpOptions just constructs a more robust
                                                                      // post request to our server.  We are asking our
                                                                      // server to return it as JSON.
    .pipe(
      catchError(this.handleError<any>('cannot register team!'))
    )
  }
  

  /*
  * POST
  */
  public findTrainer(trainer: Trainer): Observable<Trainer>{
    return this.http.post<Trainer>(`${POKEMON_URL}TrainerGetByUsername`, trainer, this.httpOptions)
    .pipe(
    //  catchError(this.handleError<Trainer>('getTrainer', undefined))
    )
  }

  /*
  * HTTP GET
  */
  public findAllTrainer(): Observable<Trainer[]> {
    return this.http.get<Trainer[]>(`${POKEMON_URL}TrainerGetAll`)
    .pipe(
      catchError(this.handleError<Trainer[]>('getTrainers', []))
    );
  } // This needs to be tied with the TrainerControllerImpl based on the logic established with the instructor example & approach

  public findTrainerByID(trainer:Trainer):Observable<Trainer>{
    return this.http.post<Trainer>(`http://localhost:8080/PokemonBattleApp/TrainerGetById`, trainer)
    .pipe(
      catchError(this.handleError<Trainer>('findTrainer', undefined))
    )
}

public findAllTrainers():Observable<Trainer[]>{
  return this.http.get<Trainer[]>(`http://localhost:8080/PokemonBattleApp/TrainerGetAll`)
  .pipe(
    catchError(this.handleError<Trainer[]>('findTrainer', []))
  );
}

public findTrainerByUser(trainer:Trainer):Observable<Trainer>{
  return this.http.post<Trainer>(`http://localhost:8080/PokemonBattleApp/TrainerGetByUsername`, trainer)
  .pipe(
    catchError(this.handleError<Trainer>('findTrainer', undefined))
  )
}

  private handleError<T>(operation = 'operation', result?:T) {
    return (error: any):Observable<T> => {
      console.error(error);
      return of(result as T);
    }
  }
}
