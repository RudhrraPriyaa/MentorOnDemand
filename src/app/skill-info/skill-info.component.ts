import { Component, OnInit, Input } from '@angular/core';
import { skills } from '../Model/Skills';
import { TechnologyServiceService } from '../Services/technology-service.service';
import { mentorSkills } from '../Model/MentorSkills';
import { AuthServiceService } from '../Services/auth-service.service';
import { MentorServiceService } from '../Services/mentor-service.service';

@Component({
  selector: 'app-skill-info',
  templateUrl: './skill-info.component.html',
  styleUrls: ['./skill-info.component.css']
})
export class SkillInfoComponent implements OnInit {

  @Input() mentorList: mentorSkills[]

  skill: skills[];
  error: string = '';
  constructor(private skillService: TechnologyServiceService, private authService: AuthServiceService, private mentorService: MentorServiceService) { }

  ngOnInit() {
  }
  book(mentorName: string, traineeName: string, skillName: string) {
    console.log(mentorName, traineeName, skillName)
    this.mentorService.book(mentorName, traineeName, skillName).subscribe((data) => {
      alert('Booked successfully')
    }, error => {
      alert('Booking Already Exists');
      this.error = error.error.message;
      if (error.error.errors != null) {

        this.error = error.error.errors;
      }
    })

  }

}
