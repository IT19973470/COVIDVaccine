import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';

// import * as EventEmitter from "events";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  @Input() stName;
  @Output() stNameChange = new EventEmitter<string>();
  myStName;

  constructor() {
  }

  ngOnInit(): void {
  }

  changeVal(txt){
    this.stNameChange.emit(txt)
  }
}
