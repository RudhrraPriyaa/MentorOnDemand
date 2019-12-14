import { Injectable } from '@angular/core';
import { mentor } from '../Model/Mentor';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { mentorSkills } from '../Model/MentorSkills';
import { trainee } from '../Model/Trainee';

@Injectable({
  providedIn: 'root'
})
export class SignUpServiceService {

  constructor(private _httpClient: HttpClient) { }

  addMentor(mentorList: mentor): Observable<mentor> {
    return this._httpClient.post<mentor>(environment.baseUrl + "/mentor", mentorList);

  }

  addTrainee(traineeList: trainee): Observable<any> {
    return this._httpClient.post<trainee>(environment.baseUrl + "/trainee", traineeList);
  }


}