import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  loggedInUser = { loggedOut: true };
  validCredentials: boolean = true;
  mentorStatus: boolean = false;
  accessToken: string;
  redirectUrl = '/';
  name: string;
  loggedIn: boolean = false;
  token: string;
  isApproval = false;
  username: string;
  error: string = "Login Failed";
  isAdministrator: boolean = false;
  userRole: String;
  status: string;
  isTrainee: boolean = false;
  isMentor: boolean = false;

  constructor(public router: Router,
    private _httpClient: HttpClient) { }
  authenticateSpring(user: string, password: string): Observable<any> {
    console.log("authenticcation1")
    let credentials = btoa(user + ':' + password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic ' + credentials)
    console.log(headers);
    console.log("authentication2")
    return this._httpClient.get(environment.baseUrl + "/authentication", { headers })
  }
  public setToken(token: string) {

    this.token = token;
    console.log("Setting the token" + this.token);
  }
  public getToken() {
    return this.token;
  }
  public setStatus(status: string) {
    this.status = status;
    console.log("status" + this.status);
  }
  public getStatus() {
    return this.status;
  }

  authenticateUser(user) {

    this.authenticateSpring(user.username, user.password).subscribe(
      (data) => {
        this.loggedInUser = user;
        this.validCredentials = true;
        this.loggedIn = true;
        this.setToken(data.token);
        this.setStatus(data.status);
        this.username = data.username;
        this.userRole = data.role;
        if (this.userRole == 'mentor') {
          if (this.getStatus() == "true") {
            this.isApproval = true;
            this.mentorStatus = true;
          }
          this.isMentor = true;
          this.isTrainee = false;
          this.router.navigate(['mentorHome']);
        }
        else if (this.userRole == 'trainee') {

          if (this.getStatus() == "true") {
            this.isApproval = true;
            this.mentorStatus = true;

          }
          this.isTrainee = true;
          this.isMentor = false;
          this.router.navigate(['search']);
        }
        else {

          this.isMentor = false;
          this.isTrainee = false;
          if (this.getStatus() == "true") {
            this.isApproval = true;
          }
          this.router.navigate(['search']);

        }

      },
      (error) => {
        this.validCredentials = false;
      }
    )
  }
  logout() {
    this.loggedInUser = { loggedOut: true };
    this.loggedIn = false;
    this.isMentor = false;
    this.isTrainee = false;
    this.setToken(null);
    this.setStatus(null);
    this.username = null;
    this.isApproval = false;
    this.router.navigate(['login']);
  }
}
