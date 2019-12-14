import { Component, OnInit } from '@angular/core';
import { MentorServiceService } from '../Services/mentor-service.service';
import { mentor } from '../Model/Mentor';
import { TechnologyServiceService } from '../Services/technology-service.service';
import { skills } from '../Model/Skills';
import { mentorSkills } from '../Model/MentorSkills';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  skill: skills[];
  mentorSkills: mentorSkills[];
  nameSearch: string;
  filteredlist: skills[];
  mentorList: mentorSkills[];
  constructor(private skillService: TechnologyServiceService) { }

  ngOnInit() {

    this.skillService.searchAll().subscribe((data) => {
      this.mentorSkills = data;
      this.mentorList = data;
    })
  }
  search() {
    console.log(this.nameSearch)
    if (this.nameSearch == "")
      this.ngOnInit();
    this.mentorList = this.mentorSkills.filter(l => (l.skillId.skillName.toLowerCase().match(this.nameSearch.toLocaleLowerCase())))
  }

}
