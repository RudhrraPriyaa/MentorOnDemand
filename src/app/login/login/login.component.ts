import { Component, OnInit, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/Services/auth-service.service';
export class User {
  constructor(public userId: string,
    public password: string) {
  }
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup
  loggedIn = new EventEmitter<User>();


  constructor(private formBuild: FormBuilder, private router: Router, private authService: AuthServiceService) { }
  ngOnInit() {
    this.loginForm = this.formBuild.group({
      username: ['', [
        Validators.required,
        Validators.pattern("^[a-zA-Z]*$"),
      ]],
      password: ['', [
        Validators.required,
        Validators.minLength(6),
      ]]
    })
  }
  get username() {
    return this.loginForm.get('username');
  }
  get password() {
    return this.loginForm.get('password');
  }
  toSignup() {
    this.router.navigate(['signup'])
  }
  login() {
    console.log(`Login ${this.loginForm.value}`);
    if (this.loginForm.valid) {
      this.loggedIn.emit(
        new User(
          this.loginForm.value.username,
          this.loginForm.value.password
        )
      );
    }
  }

}