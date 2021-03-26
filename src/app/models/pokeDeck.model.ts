export class PokeDeck {
    id: number;
    trainerId: number;
    pokemonId: number;

    constructor(id:number, trainerId: number, pokemonId:number) {
      this.id = id;
      this.trainerId = trainerId;
      this.pokemonId = pokemonId;
    }
  }
  