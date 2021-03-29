import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { POKEMON_URL } from 'src/environments/environment';
import { ClientMessage } from '../models/client-message.model';
import { PokeDeck } from '../models/pokeDeck.model';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PokeDeckService {

  constructor(private http:HttpClient) { }

  /*
  * POST
  */
    public registerPokeDeck(pokeDeck: PokeDeck): Observable<ClientMessage> {
      return this.http.post<ClientMessage>(`${POKEMON_URL}PokeDeckInsert`, pokeDeck) //Please do changes on either code for name consistent
      .pipe(
        catchError(this.handleError<any>('cannot register PokeDeck!'))
      );
    }

    /*
    * POST
    */
    public updatePokeDeck(pokeDeck: PokeDeck): Observable<PokeDeck>{
      return this.http.post<PokeDeck>(`${POKEMON_URL}PokeDeckUpdate`, pokeDeck)
      .pipe(
        catchError(this.handleError<PokeDeck>('updatePokeDeck', undefined))
      )
    }

    /*
    * HTTP POST
    */
    public findPokeDeckById(pokeDeck: PokeDeck): Observable<PokeDeck[]> {
      return this.http.post<PokeDeck[]>(`${POKEMON_URL}PokeDeckGetById`, pokeDeck)
      .pipe(
        catchError(this.handleError<PokeDeck[]>('getPokeDeckById', []))
      );
    }

    public findPokeDeckByTrainerId(pokeDeck: PokeDeck): Observable<PokeDeck[]> {
      return this.http.post<PokeDeck[]>(`${POKEMON_URL}PokeDeckGetByTrainerId`, pokeDeck)
      .pipe(
        catchError(this.handleError<PokeDeck[]>('getPokeDeckByTrainerId', []))
      );
    }

    /*
    * HTTP GET
    */
    public findAllPokeDeck(): Observable<PokeDeck[]> {
      return this.http.get<PokeDeck[]>(`${POKEMON_URL}PokeDeckGetAll`)
      .pipe(
        catchError(this.handleError<PokeDeck[]>('getPokeDeck', []))
      );
    }

    private handleError<T>(operation = 'operation', result?:T) {
      return (error: any):Observable<T> => {
        console.error(error);
        return of(result as T);
      }
    }
}
