package com.cognizant.authenticationservice;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.authenticationservice.controller.UserController;
import com.cognizant.authenticationservice.model.Mentor;
import com.cognizant.authenticationservice.model.MentorSkills;
import com.cognizant.authenticationservice.repository.MentorRepository;

@SpringBootTest
public class AuthenticationServiceApplicationTests {

    @Mock
    UserController userController;
    
    @Autowired
    MentorRepository mentorRepository;
    
    @Before
    public void init() {
           MockitoAnnotations.initMocks(this);
    }

    
    @Test
    public void getSkills() {
    
           Mentor mentor1=new Mentor();
           mentor1.setConfirmPassword("pwd");
           mentor1.setMentorContact("9098987656");
           mentor1.setEmail("aa");
           mentor1.setMentorFirstName("rahul");
           mentor1.setId(1);
           mentor1.setMentorLastName("A");
           mentor1.setPassword("pwd");
           mentor1.setMentorName("rahul");
           mentor1.setYearsOfExperience((long) 9);
           mentor1.setLinkedinUrl("rahul");
           
           List<Mentor> mentor = new ArrayList<>();
           mentor.add(mentor1);
           when(userController.getMentors()).thenReturn(mentor);
           
           //test
           List<Mentor> testMentor=userController.getMentors();
           assertEquals(1, testMentor.size());
           for(Mentor mentors : testMentor) {
                  assertEquals("rahul", mentors.getMentorFirstName());
           }
           
           verify(userController).getMentors();
           
    
    }
    
    @Test
    public void getMentorSkills() {
    
           MentorSkills mentorSkills =new MentorSkills();
           mentorSkills.setYearsOfExperience(1);
           mentorSkills.setFacilitiesOffered("notes");
           mentorSkills.setMentorSkillId(1);
           mentorSkills.setRating(9);
           mentorSkills.setTrainingdelivered(6);
           List<MentorSkills> mentorskill = new ArrayList<>();
           mentorskill.add(mentorSkills);
           when(userController.getMentorSkills()).thenReturn(mentorskill);
           Integer testid = new Integer("1");
           List<MentorSkills> testMentorSkill=userController.getMentorSkills();
           assertEquals(1, testMentorSkill.size());
           for(MentorSkills mentorskills : testMentorSkill) {
                  assertEquals( testid, mentorskills.getMentorSkillId());
           }
           verify(userController).getMentorSkills();
           
    }


}
