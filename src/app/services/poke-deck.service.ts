import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { POKEMON_URL } from 'src/environments/environment';
import { ClientMessage } from '../models/client-message.model';
import { PokeDeck } from '../models/PokeDeck.model';
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
      return this.http.post<ClientMessage>(`${POKEMON_URL}registerPokeDeck`, pokeDeck) //Please do changes on either code for name consistent
      .pipe(
        catchError(this.handleError<any>('cannot register PokeDeck!'))
      );
    }

    /*
    * POST
    */
    public findPokeDeck(pokeDeck: PokeDeck): Observable<PokeDeck>{
      return this.http.post<PokeDeck>(`${POKEMON_URL}findPokeDeck`, pokeDeck)
      .pipe(
        catchError(this.handleError<PokeDeck>('getPokeDeck', undefined))
      )
    }

    /*
    * HTTP GET
    */
    public findAllPokeDeck(): Observable<PokeDeck[]> {
      return this.http.get<PokeDeck[]>(`${POKEMON_URL}findAllPokeDeck`)
      .pipe(
        catchError(this.handleError<PokeDeck[]>('getPokeDeck', []))
      );
    } // This needs to be tied with the TrainerControllerImpl based on the logic established with the instructor example & approach

    private handleError<T>(operation = 'operation', result?:T) {
      return (error: any):Observable<T> => {
        console.error(error);
        return of(result as T);
      }
    }
}
