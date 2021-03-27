import { Component, OnInit } from '@angular/core';
import { Trainer } from '../models/trainer';
import {FormBuilder} from '@angular/forms';
import {Router} from '@angular/router';
import { TrainerService } from '../services/trainer.service';
import { ClientMessage } from '../models/client-message.model';




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

  constructor(private trainerService:TrainerService , private router:Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {

  }

  public findHeroFromService(): void {

    this.trainerService.findTrainer(this.trainer).subscribe(data => this.recievedTrainer = data, // make sure you are setting your data equal here
      error => this.clientMessage.message = 'SOMETHING WENT WRONG');
      sessionStorage.setItem('trainer',JSON.stringify(this.trainer));
      sessionStorage.getItem('username');

  }

}
