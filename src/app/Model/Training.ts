import { mentor } from './Mentor';

import { trainee } from './Trainee';
import { skills } from './Skills';

export interface training{
    id:number,
    mentorId:mentor,
    traineeId:trainee,
    proposalStatus:string,
    skillId:skills
}