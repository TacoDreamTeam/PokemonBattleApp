import { ClientMessage } from './../models/client-message.model';
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  public clientMessage: ClientMessage = new ClientMessage('This is a placeholder');

  constructor() { }

  ngOnInit(): void {
  }

}
