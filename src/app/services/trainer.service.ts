<<<<<<< HEAD
import { POKEMON_URL } from './../../environments/environment';
import { catchError } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { Trainer } from './../models/trainer';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
=======
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Trainer } from './../models/trainer';
import { Observable, of } from 'rxjs';
import { POKEMON_URL } from './../../environments/environment'
import { ClientMessage } from './../models/client-message.model';
import { catchError } from 'rxjs/operators';
>>>>>>> f97b770c0244b0f4da55f31af969a35417a3b9ad

@Injectable({
  providedIn: 'root'
})
export class TrainerService {

  httpOptions = {
<<<<<<< HEAD
    headers: new HttpHeaders({'Content-type' : 'application/json'})
=======
    // Shout out to Farid for figuring out that Content-Type must have a "-" if used
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
>>>>>>> f97b770c0244b0f4da55f31af969a35417a3b9ad
  }

  constructor(private http: HttpClient) { }

<<<<<<< HEAD
  public registerTrainer(trainer: Trainer, pokemonId: number): Observable<any>{
    return this.http.post<any>(`${POKEMON_URL}`, trainer).pipe(
      catchError(this.handleError<any>('registerTrainer'))
    )
  }

  private handleError<T>(operation = 'operation', result?: T){
    return (error:any): Observable<T> => {
      console.error(error);

      return of(result as T)
    }
  }
}
=======
  /*
  * POST
  */
  public registerTrainer(trainer: Trainer): Observable<ClientMessage> {
    return this.http.post<ClientMessage>(`${POKEMON_URL}TrainerInsert`, trainer,this.httpOptions) //Please do changes on either code for name consistent
    .pipe(
      catchError(this.handleError<any>('cannot register trainer!'))
    ); 
  }

  /*
  * POST
  */
  public updateTrainer(trainer: Trainer): Observable<Trainer>{
    return this.http.post<Trainer>(`${POKEMON_URL}TrainerUpdate`, trainer, this.httpOptions)
    .pipe(
      catchError(this.handleError<Trainer>('updateTrainer', undefined))
    )
  }

  /*
  * POST
  */
  public findTrainerById(trainer: Trainer): Observable<Trainer>{
    return this.http.post<Trainer>(`${POKEMON_URL}TrainerGetById`, trainer, this.httpOptions)
    .pipe(
      catchError(this.handleError<Trainer>('findTrainerById', undefined))
    )
  }

  /*
  * POST
  */
  public findTrainerByUsername(trainer: Trainer): Observable<Trainer>{
    return this.http.post<Trainer>(`${POKEMON_URL}TrainerGetByUsername`, trainer, this.httpOptions)
    .pipe(
      catchError(this.handleError<Trainer>('findTrainerByUsername', undefined))
    )
  }

  /*
  * HTTP GET
  */
  public findAllTrainer(): Observable<Trainer[]> {
    return this.http.get<Trainer[]>(`${POKEMON_URL}TrainerGetAll`, this.httpOptions)
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
>>>>>>> f97b770c0244b0f4da55f31af969a35417a3b9ad
