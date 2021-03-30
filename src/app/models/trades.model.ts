export class Trades {
    id: number;
    wantsPokeId: number;
    hasPokeId: number;
    pokemonWanted: number;
    pokemonHas: number;
    status: string;
  
    constructor(id:number, wantsPokeId:number, hasPokeId: number, pokemonWanted:number, pokemonHas:number, status:string) {
      this.id = id;
      this.wantsPokeId = wantsPokeId;
      this.hasPokeId = hasPokeId;
      this.pokemonWanted = pokemonWanted;
      this.pokemonHas = pokemonHas;
      this.status = status;
    }
  }
  