import { Injectable } from '@angular/core';
import { mentor } from '../Model/Mentor';
import { HttpHeaders, HttpClientModule, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Subject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MentorServiceService {

  private subject = new Subject<mentor[]>();
  token: string;
  constructor(private _httpClient: HttpClient) { }

  getAllMentors() {

    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.token);
    return this._httpClient.get<mentor[]>(environment.baseUrl + "/mentor", { headers });

  }

  getSubject(): Subject<mentor[]> {
    return this.subject;
  }

  book(mentorName: string, traineeName: string, skillName: string) {
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.token);
    return this._httpClient.post(environment.userUrl + "/proposal/" + mentorName + "/" + traineeName + "/" + skillName, { headers });
  }

}
