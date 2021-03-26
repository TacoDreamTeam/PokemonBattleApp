export class Trainer {
  trainerId: number;
  username:string;
  password:string
  firstName:string;
  lastName:string;

  constructor(trainerId:number, username:string, password:string, firstName:string, lastName:string) {
    this.trainerId = trainerId;
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
