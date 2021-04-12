import { Type } from './../models/type';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import {catchError} from 'rxjs/operators'



@Injectable({
  providedIn: 'root'
})
export class TypeService {

  constructor(private http:HttpClient) { }

  httpOptions={
    headers:new HttpHeaders({'Content-Type':'application/json'})
  }

  public getEffectiveness(type1: string, type2:string):Observable<number>{
    console.log(`type1: ${type1}, type2: ${type2}`)
    let type:Type =new Type(type1, type2);
    console.log(type);
    return this.http.post<number>(`http://localhost:8080/PokemonBattleApp/PokemonTypeEffectivness`, type)
      .pipe(
        catchError(this.handleError<number>('findTeam', undefined))
      )
  }
  // error handling
  private handleError<T>(operation='operation', result?:T){
    return (error: any): Observable<T>=>{
      console.error(error); //log error to the console if something goes wrong
      
      //Let the app keep runing by returing an empty result.
      return of(result as T);
    }

  }


}
