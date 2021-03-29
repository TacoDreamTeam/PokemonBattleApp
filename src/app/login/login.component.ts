import { Component, OnInit } from '@angular/core';
import { Trainer } from '../models/trainer';
import {FormBuilder} from '@angular/forms';
import {Router} from '@angular/router';
import { TrainerService } from '../services/trainer.service';
import { ClientMessage } from '../models/client-message.model';
import { AuthorizeService } from '../services/authorize.service';



export const AUTH_TOKEN_KEY = 'auth-token';
export const AUTH_USER_DATA = 'user-data';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {



public trainer: Trainer = new Trainer(0,'', '','','');

public recievedTrainer: Trainer = new Trainer(0,'', '','','');
  // Message to the User.
  public clientMessage: ClientMessage = new ClientMessage('');

  public authToken: any = null;
  public userData: Trainer | any = null;

  constructor(
    private trainerService:TrainerService ,
    private router:Router,
    private formBuilder: FormBuilder,
    public authService:AuthorizeService) { }

  ngOnInit(): void {

    this.dropSession();
    console.log(this.dropSession());

  }


  public findHeroFromService(): void {
    if(this.trainer.username===''|| this.trainer.password===''){
      alert("Please enter something");
    }else if(this.trainer){
      this.trainerService.findTrainer(this.trainer).subscribe((data) =>{
      this.recievedTrainer = data;
      sessionStorage.setItem("currentTrainer",JSON.stringify(this.recievedTrainer))},
      error => this.clientMessage.message = 'SOMETHING WENT WRONG');
      console.log(sessionStorage.getItem("currentTrainer"))
    }


  }

  dropSession(){
    sessionStorage.clear();
  }

}
