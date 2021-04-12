export class Trainer {
  
  trainerId: number  | null |any;
  username:string  | null |any;
  password:string  | null |any;
  firstName:string   | null |any;
  lastName:string   | null |any;
  teamId: number | null | any;

  constructor(trainerId:number   | null |any,
     username:string   | null |any,
     password:string  | null |any,
     firstName:string  | null |any,
     lastName:string  | null |any,
     teamId: number | null | any) {
    this.trainerId = trainerId;


    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.teamId = teamId;
  }
}
