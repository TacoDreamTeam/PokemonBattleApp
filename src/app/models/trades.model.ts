export class Trades {
    id: number;
    wants_trainer_id: number;
    has_trainer_id: number;
    pokemon_wanted_id: number;
    pokemon_had_id: number;
    status: string;
  
    constructor(id:number, wants_trainer_id:number, has_trainer_id: number, pokemon_wanted_id:number, pokemon_had_id:number, status:string) {
      this.id = id;
      this.wants_trainer_id = wants_trainer_id;
      this.has_trainer_id = has_trainer_id;
      this.pokemon_wanted_id = pokemon_wanted_id;
      this.pokemon_had_id = pokemon_had_id;
      this.status = status;
    }
  }
  