import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RandomIntService {

  constructor() { }

  // https://www.devstudioonline.com/article/get-random-integer-in-javascript
  getRandomInt(min, max){
    min=Math.ceil(min);
    max=Math.floor(max);
    return Math.floor(Math.random()*(max-min+1))+min;
  }

}
