export class PokeDeck {
    id: number;
    trainer_id: number;
    pokemon_id: number;

    constructor(id:number, trainer_id: number, pokemon_id:number) {
      this.id = id;
      this.trainer_id = trainer_id;
      this.pokemon_id = pokemon_id;
    }
  }
  