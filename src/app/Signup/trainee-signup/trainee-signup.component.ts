import { Component, OnInit } from '@angular/core';
import { trainee } from 'src/app/Model/Trainee';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { SignUpServiceService } from 'src/app/Services/sign-up-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-trainee-signup',
  templateUrl: './trainee-signup.component.html',
  styleUrls: ['./trainee-signup.component.css']
})
export class TraineeSignupComponent implements OnInit {

  signUpForm: FormGroup;
  trainee: trainee;
  constructor(private formBuilder: FormBuilder, private signService: SignUpServiceService, private router: Router) { }

  ngOnInit() {
    this.signUpForm = this.formBuilder.group({
      traineeName: ['', [
        Validators.required,
        this.isUsernameTaken
      ]],
      traineeFirstName: ['', [
        Validators.required
      ]],
      traineeLastName: ['', [
        Validators.required
      ]],
      traineeContact: ['', [
        Validators.required
      ]],
      email: ['', [
        Validators.required
      ]],
      password: ['', [
        Validators.required
      ]],
      confirmPassword: ['', [
        Validators.required,
        this.matchConfirmPassword.bind(this)
      ]]
    })
  }
  get traineeName() {
    return this.signUpForm.get('traineeName');
  }
  get traineeLastName() {
    return this.signUpForm.get('traineeLastName');
  }
  get traineeFirstName() {
    return this.signUpForm.get('traineeFirstName');
  }
  get traineeContact() {
    return this.signUpForm.get('traineeContact');
  }
  get email() {
    return this.signUpForm.get('email');
  }
  get password() {
    return this.signUpForm.get('password');
  }
  get confirmPassword() {
    return this.signUpForm.get('confirmPassword');
  }

  matchConfirmPassword(formControl: FormControl): { [s: string]: boolean } {
    if (this.signUpForm) {
      if (formControl.value && formControl.value.length > 0 && formControl.value !== this.signUpForm.get('password').value) {
        return { 'nomatch': true };
      }
    }
    return null;
  }
  isUsernameTaken(formControl: FormControl): { [s: string]: boolean } {
    if (formControl.value === 'admin') {
      return { 'userNameTaken': true };
    } else {
      return null;
    }
  }
  submit(traineelist: trainee) {
    console.log(traineelist);
    this.signService.addTrainee(traineelist).subscribe((data) => {
      alert('signed up successfully!!!');
      this.router.navigate(['login']);
    })

  }
}