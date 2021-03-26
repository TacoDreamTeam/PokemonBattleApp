import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { POKEMON_URL } from 'src/environments/environment';
import { ClientMessage } from '../models/client-message.model';
import { Team } from '../models/team.model';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private http: HttpClient) { }

  /*
  * POST
  */
    public registerTeam(team: Team): Observable<ClientMessage> {
      return this.http.post<ClientMessage>(`${POKEMON_URL}TeamInsert`, team) //Please do changes on either code for name consistent
      .pipe(
        catchError(this.handleError<any>('cannot register team!'))
      ); 
    }
  
    /*
    * POST
    */
    public updateTeam(team: Team): Observable<Team>{
      return this.http.post<Team>(`${POKEMON_URL}TeamUpdate`, team)
      .pipe(
        catchError(this.handleError<Team>('updateTeam', undefined))
      )
    }

    /*
    * HTTP POST
    */
    public findAllTeamsById(team: Team): Observable<Team[]> {
      return this.http.post<Team[]>(`${POKEMON_URL}TeamGetById`, team)
      .pipe(
        catchError(this.handleError<Team[]>('getTeamsById', []))
      ); 
    } 

    /*
    * HTTP GET
    */
    public findAllTeams(): Observable<Team[]> {
      return this.http.get<Team[]>(`${POKEMON_URL}TeamGetAll`)
      .pipe(
        catchError(this.handleError<Team[]>('getTeams', []))
      ); 
    } 
  
    private handleError<T>(operation = 'operation', result?:T) {
      return (error: any):Observable<T> => {
        console.error(error);
        return of(result as T);
      }
    }
}
