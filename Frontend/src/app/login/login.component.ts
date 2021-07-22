import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  myStName;
  studentName = 'ABC';
  x = 7;

  students = ['Gayan', 'Sashini', 'Varnavi', 'Navoda'];

  constructor() {
  }

  ngOnInit(): void {
  }

  clickMe() {
    if (this.x > 7) {
      this.x = 3;
    } else {
      this.x = 9;
    }
  }

  pushToArr() {
    this.students.push(this.studentName)

    // for(let student of this.students){
    //
    // }
  }
}
