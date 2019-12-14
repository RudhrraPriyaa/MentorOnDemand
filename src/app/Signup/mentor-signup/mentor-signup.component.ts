import { Component, OnInit, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { mentor } from 'src/app/Model/Mentor';
import { SignUpServiceService } from 'src/app/Services/sign-up-service.service';
import { Router } from '@angular/router';

export class User {
  constructor(public userID: string,
    public firstName: string, public lastName: string, public yearsOfExperience: number,public linkedInUrl: string,public contactNo: number,public email:string,public  password:string,public confirmPassword:string) {
  }
}

@Component({
  selector: 'app-mentor-signup',
  templateUrl: './mentor-signup.component.html',
  styleUrls: ['./mentor-signup.component.css']
})
export class MentorSignupComponent implements OnInit {

  signUpForm: FormGroup;
  mentor:mentor;
  signedIn = new EventEmitter<User>();



  constructor(private formBuilder: FormBuilder, private signService: SignUpServiceService,private router:Router) { }

  ngOnInit() {
    this.signUpForm = this.formBuilder.group({
      mentorName: ['', [
        Validators.required,
        this.isUsernameTaken,
        Validators.pattern("^[a-zA-Z]*$"),
      ]],
      mentorFirstName: ['', [
        Validators.required
      ]],
      mentorLastName: ['', [
        Validators.required
      ]],
      yearsOfExperience: ['', [
        Validators.required
      ]],
      linkedinUrl: ['', [
        Validators.required
      ]],
      mentorContact: ['', [
        Validators.required
      ]],
      email: ['', [
        Validators.required
      ]],
      password: ['', [
        Validators.required,
        Validators.minLength(3),
      ]],
      confirmPassword: ['', [
        Validators.required,
        this.matchConfirmPassword.bind(this)
      ]]
    })
  }
  get mentorName() {
    return this.signUpForm.get('mentorName');
  }
  get mentorFirstName() {
    return this.signUpForm.get('mentorFirstName');
  }
  get mentorLastName() {
    return this.signUpForm.get('mentorLastName');
  }
  get yearsOfExperience() {
    return this.signUpForm.get('yearsOfExperience');
  }
  get linkedinUrl() {
    return this.signUpForm.get('linkedinUrl');
  }
  get mentorContact() {
    return this.signUpForm.get('mentorContact');
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
  submit(mentorlist:mentor){
    console.log(mentorlist);
    this.signService.addMentor(mentorlist).subscribe((data)=>{
      alert('signed up successfully!!!');
      this.router.navigate(['login']);
    })
  }



  submitToAdd(mentorlist:mentor){
    console.log(mentorlist);
    this.signService.addMentor(mentorlist).subscribe((data)=>{
      alert('signed added');
      this.router.navigate(['addSkill',mentorlist.mentorName]);
    })
  }
  signupmentor() {
    
    if (this.signUpForm.valid) {
      this.signedIn.emit(
        new User(
          this.signUpForm.value.mentorName,
          this.signUpForm.value.mentorFirstName,
          this.signUpForm.value.mentorLastName,
          this.signUpForm.value.yearsOfExperience,
          this.signUpForm.value.linkedinUrl,
          this.signUpForm.value.mentorContact,
          this.signUpForm.value.email,
          this.signUpForm.value.password,
          this.signUpForm.value.confirmPassword,

        )
      );
    }
  }

}
