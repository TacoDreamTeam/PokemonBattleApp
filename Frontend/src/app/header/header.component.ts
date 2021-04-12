import { Component, OnInit } from '@angular/core';
import { AuthorizeService } from '../services/authorize.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public authService:AuthorizeService) { }

  ngOnInit(): void {
  }




  logOut(){
    sessionStorage.removeItem("currentTrainer");
  }

}
