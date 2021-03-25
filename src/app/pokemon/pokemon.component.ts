import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../services/pokemon.service';

@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.css'],
})
export class PokemonComponent implements OnInit {
  pokemons: any[] = [];
  page=1;
  totalPokemon=0;

  constructor(private pokemonService: PokemonService) {}

  ngOnInit() {
    this.getPokemons();
  }

  getPokemons(): void {
    this.pokemonService.getPokemon().subscribe((res: any) => {
      this.totalPokemon=res.count;
      res.results.forEach((data) => {
        this.pokemonService.getMoreData(data.name).subscribe((uniqRes: any) => {
          this.pokemons.push(uniqRes);
          console.log(this.pokemons);
        });
      });
    });
  }
}
