import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Trainer } from '../models/trainer';

@Component({
  selector: 'app-trainer-dash',
  templateUrl: './trainer-dash.component.html',
  styleUrls: ['./trainer-dash.component.css']
})
export class TrainerDashComponent implements OnInit {

    sessionValue:any='';
    currentUser:any
  router: any;
  constructor(router:Router) { }

  ngOnInit(): void {
   this.sessionValue=sessionStorage.getItem("currentTrainer");
    this.currentUser=JSON.parse(this.sessionValue)
   console.log(this.currentUser);

   this.goToPage();


  }






goToPage(){
  if(this.currentUser===null){
    this.router.navigate(['/login'])
  }
}

}
