import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from './Services/auth-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'MentorOnDemand';

  isMentor :boolean
constructor(public router: Router,private authService:AuthServiceService){}
ngOnInit(): void {
  this.isMentor=this.authService.isMentor;
  //this.loggedIn();
  this.router.navigate(['search']);
}
}
