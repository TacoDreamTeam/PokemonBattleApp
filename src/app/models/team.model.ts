export class Team {
    id: number;
    trainer_id: number;
    pokemonId1: number;
    pokemonId2: number;
    pokemonId3: number;
    pokemonId4: number;
    pokemonId5: number;
    pokemonId6: number;

    constructor(id:number, trainer_id:number, pokemonId1:number, pokemonId2:number, pokemonId3:number,
        pokemonId4:number, pokemonId5:number, pokemonId6:number) {
      this.id = id;
      this.trainer_id = trainer_id;
      this.pokemonId1 = pokemonId1;
      this.pokemonId2 = pokemonId2;
      this.pokemonId3 = pokemonId3;
      this.pokemonId4 = pokemonId4;
      this.pokemonId5 = pokemonId5;
      this.pokemonId6 = pokemonId6;  
    }
  }
  