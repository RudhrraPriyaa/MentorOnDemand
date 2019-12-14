import { mentor } from './Mentor';
import { skills } from './Skills';

export interface mentorSkills {
    rating:number,
    yearsOfExperience:number,
    trainingdelivered:number,
    facilitiesOffered:string,
    mentorId:mentor,
    skillId:skills
    // skillName:string,
    // mentorName:string
}
