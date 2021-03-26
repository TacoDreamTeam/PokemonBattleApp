import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Trainer } from './../models/trainer';
import { Observable, of } from 'rxjs';
import { POKEMON_URL } from './../../environments/environment'
import { ClientMessage } from './../models/client-message.model';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TrainerService {

  constructor(private http: HttpClient) { }

  /*
  * POST
  */
  public registerTrainer(trainer: Trainer): Observable<ClientMessage> {
    return this.http.post<ClientMessage>(`${POKEMON_URL}registerTrainer`, trainer) //Please do changes on either code for name consistent
    .pipe(
      catchError(this.handleError<any>('cannot register trainer!'))
    ); 
  }

  /*
  * POST
  */
  public findTrainer(trainer: Trainer): Observable<Trainer>{
    return this.http.post<Trainer>(`${POKEMON_URL}findTrainer`, trainer)
    .pipe(
      catchError(this.handleError<Trainer>('getTrainer', undefined))
    )
  }

  /*
  * HTTP GET
  */
  public findAllTrainer(): Observable<Trainer[]> {
    return this.http.get<Trainer[]>(`${POKEMON_URL}findAllTrainers`)
    .pipe(
      catchError(this.handleError<Trainer[]>('getTrainers', []))
    ); 
  } // This needs to be tied with the TrainerControllerImpl based on the logic established with the instructor example & approach

  private handleError<T>(operation = 'operation', result?:T) {
    return (error: any):Observable<T> => {
      console.error(error);
      return of(result as T);
    }
  }
}