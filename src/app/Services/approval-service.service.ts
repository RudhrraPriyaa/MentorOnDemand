import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { AuthServiceService } from './auth-service.service';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { training } from '../Model/Training';

@Injectable({
  providedIn: 'root'
})
export class ApprovalServiceService {

  constructor(private authService: AuthServiceService, private http: HttpClient) { }

  statusList(mentorName: string) {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.authService.getToken());
    return this.http.get<training[]>(environment.userUrl + "/proposal/pending/" + mentorName, { headers });
  }

  giveApproval(traineeId: number) {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.authService.getToken());
    return this.http.put(environment.userUrl + "/proposal/accepted/" + traineeId, null, { headers });
  }

  declineApproval(traineeId: number) {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.authService.getToken());
    return this.http.delete(environment.userUrl + "/proposal/decline/" + traineeId, { headers });
  }

  payNow(traineeId: number) {
    let headers = new HttpHeaders();
    return this.http.put(environment.userUrl + "/proposal/pay/" + traineeId, null, { headers });
  }

  completed(traineeId: number) {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.authService.getToken());
    return this.http.put(environment.userUrl + "/proposal/completed/" + traineeId, null, { headers });
  }

  getAllInprogressTraineeList() {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.authService.getToken());
    return this.http.get<training>(environment.userUrl + "/proposal/trainee/incomplete/" + this.authService.username, { headers });
  }

  getAllCompletedTraineeList() {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.authService.getToken());
    return this.http.get<training>(environment.userUrl + "/proposal/trainee/complete/" + this.authService.username, { headers });
  }

  getAllInprogressMentorList() {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.authService.getToken());
    return this.http.get<training>(environment.userUrl + "/proposal/mentor/incomplete/" + this.authService.username, { headers });
  }

  getAllCompletedMentorList() {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.authService.getToken());
    return this.http.get<training>(environment.userUrl + "/proposal/mentor/complete/" + this.authService.username, { headers });
  }



}
