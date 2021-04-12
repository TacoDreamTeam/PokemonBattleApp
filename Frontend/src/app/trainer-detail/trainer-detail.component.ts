import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { FormArray } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-trainer-detail',
  templateUrl: './trainer-detail.component.html',
  styleUrls: ['./trainer-detail.component.css']
})

export class TrainerDetailComponent implements OnInit {
  sessionValue:any;
 public currentUser: any;


  constructor(private fb: FormBuilder,private router:Router) { }

  ngOnInit(): void {

    this.sessionValue=sessionStorage.getItem("currentTrainer");
    this.checkForUser();

  }

checkForUser(){
  if(this.currentUser===null){
    console.log("No user detected")
    this.router.navigate(['login'])
  }else{
    this.currentUser=JSON.parse(this.sessionValue);
    console.log(this.currentUser);
  }
}

  profileForm = this.fb.group({
    firstName: ['', Validators.required],
    lastName: [''],
    username:[''],
    password:[''],
  });

  get aliases() {
    return this.profileForm.get('aliases') as FormArray;
  }

  updateProfile() {
    this.profileForm.patchValue({
      firstName: this.currentUser.firstName,
      lastName:this.currentUser.lastName,
      username:this.currentUser.username,
      password:this.currentUser.password
    });
  }

  addAlias() {
    this.aliases.push(this.fb.control(''));
  }

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.profileForm.value);
  }
}
