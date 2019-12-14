import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { mentorSkills } from '../Model/MentorSkills';
import { Validators, FormGroup, FormBuilder,FormsModule } from '@angular/forms';
import { SignUpServiceService } from '../Services/sign-up-service.service';
import { TechnologyServiceService } from '../Services/technology-service.service';

@Component({
  selector: 'app-skill-form',
  templateUrl: './skill-form.component.html',
  styleUrls: ['./skill-form.component.css']
})
export class SkillFormComponent implements OnInit {
  error: string = '';
  constructor(private router:Router,private skillsService:TechnologyServiceService,private route:ActivatedRoute,private formBuilder: FormBuilder,private signUpServiceService: SignUpServiceService) { }
  
  mentorskills:mentorSkills;
  editForm:FormGroup;
  mentorName:string;
  skillname:string;
  ngOnInit() {
    this.mentorName = this.route.snapshot.paramMap.get('mentorName');
    this.skillname=this.route.snapshot.paramMap.get('skillName');
    this.editForm = this.formBuilder.group({

      rating: ['', [
        Validators.required,
      ]],
      yearsOfExperience: ['', [
        Validators.required
      ]],
      trainingdelivered: ['', [
        Validators.required
      ]],
      facilitiesOffered: ['', [
        Validators.required
      ]],
    })
  }
 
  get rating() {
    return this.editForm.get('rating');
  }
  get yearsOfExperience() {
    return this.editForm.get('yearsOfExperience');
  }
  get trainingdelivered() {
    return this.editForm.get('trainingdelivered');
  }
  get facilitiesOffered() {
    return this.editForm.get('facilitiesOffered');
  }
  

  submit(mentorSkill:mentorSkills){
  this.skillsService.addSkills(mentorSkill,this.mentorName,this.skillname).subscribe(
    (data)=>{
      alert('Added skills!!!!');
    }
  )
  }
  add(mentorSkill:mentorSkills){
    this.skillsService.addSkills(mentorSkill,this.mentorName,this.skillname).subscribe(
      (data)=>{
        
      },error => {
        alert('Booking Already Exists');
        this.error = error.error.message;
        /*for global exception handler*/
        if (error.error.errors != null) {
        
          this.error = error.error.errors;
        }
      })
    this.router.navigate(['addSkill',this.mentorName])
  }
}
