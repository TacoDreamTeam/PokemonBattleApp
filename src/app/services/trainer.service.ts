import { POKEMON_URL } from './../../environments/environment';
import { catchError } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { Trainer } from './../models/trainer';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TrainerService {

  httpOptions = {
    headers: new HttpHeaders({'Content-type' : 'application/json'})
  }

  constructor(private http: HttpClient) { }

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
