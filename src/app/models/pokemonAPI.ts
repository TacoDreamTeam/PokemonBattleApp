export class PokemonAPI{
    id:number;
    name:string;
    front: any;
    back:any;
    type: string;
    attackName:string
    health: number;
    attack: number;
    defense: number; 
    spAttack: number;
    spDefense: number;
    speed:number;
    constructor(id:number, name:string, front: any, back:any, type:string, 
                attackName: string, health: number,attack: number, defense: number, 
                spAttack: number, spDefense: number, speed:number){
        this.id=id;
        this.name=name;
        this.front=front;
        this.back=back;
        this.type=type;
        this.attackName=attackName;
        this.health=health;
        this.attack=attack;
        this.defense=defense;
        this.spAttack=spAttack;
        this.spDefense=spDefense;
        this.speed=speed
    }
}