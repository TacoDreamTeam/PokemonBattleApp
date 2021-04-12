import { RandomIntService } from './../services/random-int.service';
import { Trainer } from './../models/trainer';
import { TrainerService } from './../services/trainer.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-pre-battle',
  templateUrl: './pre-battle.component.html',
  styleUrls: ['./pre-battle.component.css']
})
export class PreBattleComponent implements OnInit {

  constructor(private trainerService:TrainerService, 
    private randomIntService:RandomIntService) { }

//hard coded in until local storage
public trainer1:Trainer=new Trainer(803, "", "", "", "", 0);

public opponent:Trainer=new Trainer(0, "", "", "", "", 0)


ngOnInit(): void {
}


randomBattle():void{    
let trainers:Trainer[];
this.trainerService.findAllTrainers().subscribe((result)=>{
  trainers=result;
  let rnd=this.randomIntService.getRandomInt(1, trainers.length);
//   while (trainers[rnd-1].trainerId===this.trainer1.trainerId){
//     let rnd=this.randomIntService.getRandomInt(1, trainers.length);
//     console.log(`in the loop: ${rnd}`);
// }
console.log("out of loop")
this.opponent=trainers[rnd-1];
console.log(this.opponent.teamId);
});


}


battleID(IDString: string):void{
let id=parseInt(IDString);
let trainer=new Trainer(id, "", "", "", "", 0)
if (id>0){
this.trainerService.findTrainerByID(trainer).subscribe((result)=>this.opponent=result);
}
}

battleUsername(Username: string):void{
let trainer=new Trainer(0, Username, "", "", "", 0)
if (Username.length>0){
this.trainerService.findTrainerByUser(trainer).subscribe((result)=>this.opponent=result);
}
}

battle(){
  localStorage.setItem('opponent', JSON.stringify(this.opponent));
    console.log(this.opponent);
    console.log(this.opponent.teamId);
  window.location.href="http://localhost:4200/battle";
}
}
