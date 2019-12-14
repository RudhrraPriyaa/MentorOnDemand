import { Injectable } from '@angular/core';

import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { skills } from '../Model/Skills';
import { Observable, Subject } from 'rxjs';
import { mentorSkills } from '../Model/MentorSkills';

@Injectable({
  providedIn: 'root'
})
export class TechnologyServiceService {

  private subject = new Subject<skills[]>();
  constructor(private _httpClient: HttpClient) { }

  getAllSkills(): Observable<any> {

    let headers = new HttpHeaders();
    return this._httpClient.get<skills>(environment.techUrl + "/allSkills", { headers });

  }

  addSkills(mentorSkills: mentorSkills, mentorName: string, skillName: string) {
    return this._httpClient.post<mentorSkills>(environment.baseUrl + "/mentor/" + mentorName + "/" + skillName, mentorSkills);
  }

  getSubject(): Subject<skills[]> {
    return this.subject;
  }

  search(skillName: string) {
    return this._httpClient.get<mentorSkills[]>(environment.searchUrl + "/search/" + skillName)
  }
  searchAll() {
    return this._httpClient.get<mentorSkills[]>(environment.searchUrl + "/search")
  }
}
