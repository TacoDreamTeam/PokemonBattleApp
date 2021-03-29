import {
  HttpClient, HttpErrorResponse, HttpHeaders, HttpParams,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { from, Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { POKEMON_URL } from 'src/environments/environment';
import { Trainer } from '../models/trainer';



@Injectable({
  providedIn: 'root',
})
export class AuthorizeService {

  httpOptions = {
    // Shout out to Farid for figuring out that Content-Type must have a "-" if used
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }


  constructor(private http: HttpClient) {

  }

  ngOnInit(): void {

  }

  username:any='';

  login(authData:Trainer){
    sessionStorage.setItem(this.username,authData.username +'RANDOM_STRING');
    sessionStorage.setItem(this.username,JSON.stringify(authData))
    console.log(authData);
  }


  private handleError<T>(operation = 'operation', result?:T) {
    return (error: any):Observable<T> => {
      console.error(error);
      return of(result as T);
    }
  }

}

