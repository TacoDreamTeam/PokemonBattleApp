import { HttpClient, HttpErrorResponse, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { from, Observable } from 'rxjs';
import { POKEMON_URL } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class AuthorizeService {

  constructor(private http : HttpClient){}



}
