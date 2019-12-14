import { mentorSkills } from './MentorSkills';

export interface mentor {
    mentorName:string,
    mentorLastName:string,
    mentorFirstName:string,
    mentorContact:string,
    linkedinUrl:string,
    yearsOfExperience:number,
    password:string,
    email:string,
    confirmPassword:string,
    mentorSkills:mentorSkills[]
}