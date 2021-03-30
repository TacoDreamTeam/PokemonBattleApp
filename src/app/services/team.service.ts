import { HttpClient, HttpHeaders } from '@angular/common/http';
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

  httpOptions = {
    // Shout out to Farid for figuring out that Content-Type must have a "-" if used
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  }

  constructor(private http: HttpClient) { }

  /*
  * POST
  */

  public registerNewTeam(team: Team): Observable<ClientMessage>  {
    // this will return a client message if we are successfully able to POST a hero to our server
    return this.http.post<ClientMessage>(`${POKEMON_URL}TeamInsert`, team, this.httpOptions)
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

    public findTeam(team:Team):Observable<Team>{
      return this.http.post<Team>(`http://localhost:8080/PokemonBattleApp/TeamGetById`, team)
        .pipe(
          catchError(this.handleError<Team>('findTeam', undefined))
        )
    }

    private handleError<T>(operation = 'operation', result?:T) {
      return (error: any):Observable<T> => {
        console.error(error);
        return of(result as T);
      }
    }
}
