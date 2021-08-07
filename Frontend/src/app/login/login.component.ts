import {Component, OnInit} from '@angular/core';
import {LoginService} from "../_service/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  vaccineUser = {
    username: '',
    password: ''
  };
  loggedIn;

  constructor(private loginService: LoginService, private router: Router) {
  }

  ngOnInit(): void {
    this.loggedIn = true;
  }

  login() {
    this.loginService.login(this.vaccineUser).subscribe((user) => {
      if (user != null) {
        localStorage.setItem('user', user.userNic);
        this.router.navigate(['/map']);
      } else {
        this.loggedIn = false;
      }
    })
  }

}
