import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { Pokemon } from '../models/pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  pokemonUrl=` https://pokeapi.co/api/v2/pokemon?limit=100&offset=200`;

  constructor(private http:HttpClient) { }

  getPokemon():Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>(this.pokemonUrl);
  }
}
