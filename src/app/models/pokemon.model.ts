export class Pokemon {
    id: number;
    pokeApi: number;
    name: string;
    type: string;
  
    constructor(id:number, pokeApi: number, name: string, type: string) {
      this.id = id;
      this.pokeApi = pokeApi;
      this.name = name;
      this.type = type;
    }
  }
  