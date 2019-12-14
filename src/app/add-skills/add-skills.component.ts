import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { skills } from '../Model/Skills';
import { SignUpServiceService } from '../Services/sign-up-service.service';
import { TechnologyServiceService } from '../Services/technology-service.service';

@Component({
  selector: 'app-add-skills',
  templateUrl: './add-skills.component.html',
  styleUrls: ['./add-skills.component.css']
})
export class AddSkillsComponent implements OnInit {

  constructor(private route:ActivatedRoute,private signService:SignUpServiceService,private router:Router,private techService:TechnologyServiceService) { }

  technologies:any;
  ngOnInit() {
   
    this.techService.getAllSkills().subscribe((data)=>{
      this.technologies=data;
    })
  }
 
  submit(skillName:string){
    
    const mentorName = this.route.snapshot.paramMap.get('mentorName');
    this.router.navigate(['skillForm',skillName,mentorName]);
  }

}
