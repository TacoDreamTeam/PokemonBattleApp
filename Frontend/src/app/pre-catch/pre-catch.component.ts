import { Component, OnInit } from '@angular/core';
import { RandomIntService } from './../services/random-int.service';

@Component({
  selector: 'app-pre-catch',
  templateUrl: './pre-catch.component.html',
  styleUrls: ['./pre-catch.component.css']
})
export class PreCatchComponent implements OnInit {

  constructor(private randomIntService:RandomIntService) { }

  ngOnInit(): void {
  }

  
  //https://en.wikipedia.org/wiki/List_of_Pok%C3%A9mon
  options =[ 
    {value:0, name:"All"},
    {value:1, name:"Generation 1 (1-151)"},
    {value:2, name:"Generation 2 (152-251)"},
    {value:3, name:"Generation 3 (252-386)"},
    {value:4, name:"Generation 4 (387-493)"},
    {value:5, name:"Generation 5 (494-649)"},
    {value:6, name:"Generation 6 (650-721)"},
    {value:7, name:"Generation 7 (722-809)"},
    {value:8, name:"Generation 8 (810-898)"}
  ]
  selected?:string;
  printedOption?:string;
  pokemonNumber?:number;


  catch(){
    this.printedOption=this.selected
    console.log(this.selected);
    console.log(this.printedOption)

    switch(this.selected){
      case "All":
        this.pokemonNumber=this.randomIntService.getRandomInt(1, 898);
        break;
      case "Generation 1 (1-151)":
        this.pokemonNumber=this.randomIntService.getRandomInt(1, 151);
        break;
      case "Generation 2 (152-251)":
        this.pokemonNumber=this.randomIntService.getRandomInt(152, 251);
        break;
      case "Generation 3 (252-386)":
        this.pokemonNumber=this.randomIntService.getRandomInt(252, 386);
        break;
      case "Generation 4 (387-493)":
        this.pokemonNumber=this.randomIntService.getRandomInt(387, 493);
        break;
      case "Generation 5 (494-649)":
        this.pokemonNumber=this.randomIntService.getRandomInt(494, 649);
        break;
      case "Generation 6 (650-721)":
        this.pokemonNumber=this.randomIntService.getRandomInt(650, 721);
        break;
      case "Generation 7 (722-809)":
        this.pokemonNumber=this.randomIntService.getRandomInt(722, 809);
        break;
      case "Generation 8 (810-898)":
        this.pokemonNumber=this.randomIntService.getRandomInt(810, 898);
        break;
    }
    localStorage.setItem('wild', JSON.stringify(this.pokemonNumber));
    console.log(this.pokemonNumber);
    window.location.href="http://localhost:4200/catch";

  }

}
