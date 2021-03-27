import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { POKEMON_URL } from 'src/environments/environment';
import { ClientMessage } from '../models/client-message.model';
import { Trades } from './../models/trades.model';

@Injectable({
  providedIn: 'root'
})
export class TradesService {

  constructor(private http:HttpClient) { }

  /*
  * POST
  */
    public registerTrade(trades: Trades): Observable<ClientMessage> {
      return this.http.post<ClientMessage>(`${POKEMON_URL}registerTrade`, trades) //Please do changes on either code for name consistent
      .pipe(
        catchError(this.handleError<any>('cannot register trade!'))
      ); 
    }
  
    /*
    * POST
    */
    public findTrade(trades: Trades): Observable<Trades>{
      return this.http.post<Trades>(`${POKEMON_URL}findTrade`, trades)
      .pipe(
        catchError(this.handleError<Trades>('getTrade', undefined))
      )
    }
  
    /*
    * HTTP GET
    */
    public findAllTrades(): Observable<Trades[]> {
      return this.http.get<Trades[]>(`${POKEMON_URL}findAllTrades`)
      .pipe(
        catchError(this.handleError<Trades[]>('getTrades', []))
      ); 
    } // This needs to be tied with the TrainerControllerImpl based on the logic established with the instructor example & approach
  
    private handleError<T>(operation = 'operation', result?:T) {
      return (error: any):Observable<T> => {
        console.error(error);
        return of(result as T);
      }
    }
}
