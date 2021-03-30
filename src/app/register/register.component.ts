import { Component, OnInit } from '@angular/core';
import { Trainer } from '../models/trainer';
import { ClientMessage } from '../models/client-message.model';
import { TrainerService } from '../services/trainer.service';
import { PokemonService } from '../services/pokemon.service';
import { TeamService } from '../services/team.service';
import { Team } from '../models/team.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  currentVal: number=0;
  constructor(
    private trainerService: TrainerService,
    private pokemonService: PokemonService,
    private teamService: TeamService
  ) {}

  pokemons: any[] = [];
  trainers: any[] = [];
  teams: any[] = [];

  id = Math.floor(Math.random() * 100 + 1);

  ngOnInit(): void {
    this.getStartThree();
    this.trainer.trainerId=this.id;
    console.log(this.id);
  }

  public trainer: Trainer = new Trainer( 0, '', '', '', '', 0);

  public team: Team = new Team(0, 0, 0, 0, 0, 0, 0);

  // Client message to the user
  public clientMessage: ClientMessage = new ClientMessage('');

  getTrainerId(val){
    this.currentVal=0;
    console.log(val);

  }
  public registerHeroFromService(): void {
    this.trainerService.registerTrainer(this.trainer).subscribe(
      (data) => (this.clientMessage = data),
      (error) => (this.clientMessage.message = 'SOMETHING WENT WRONG!')
    );
  }

  public registerTeam(): void {
    this.trainerService.registerNewTeam(this.team).subscribe(
      (data) => (this.clientMessage = data),
      (error) => (this.clientMessage.message = 'SOMETHING WENT WRONG!')
    );
  }

  getAllTrainers(): void {
    this.trainerService
      .findAllTrainer()
      .subscribe((data) => (this.trainers = data));
    console.log(this.trainers);
  }

  // get three pokemon from the poke API for new users
  getStartThree(): void {
    this.pokemonService.getStartThree().subscribe((res: any) => {
      res.results.forEach((data) => {
        this.pokemonService.getMoreData(data.name).subscribe((uniqRes: any) => {
          this.pokemons.push(uniqRes);
          console.log(this.pokemons);
        });
      });
    });
  }
}
