package com.cognizant.searchservice;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.searchservice.model.MentorSkills;
import com.cognizant.searchservice.repository.MentorSkillsRepository;
import com.cognizant.searchservice.service.SearchService;

@SpringBootTest
public class SearchServiceApplicationTests {
    @Mock
    SearchService searchService;
    
    @Mock
    MentorSkillsRepository mentorSkillsRepository;
    
    @Autowired
    private MockMvc mvc;

    
    @Before
    public void init() {
                    MockitoAnnotations.initMocks(this);
    }

    
    @Test
    public void search() {
    
                    MentorSkills mentorSkills =new MentorSkills();
                    mentorSkills.setYearsOfExperience(1);
                    mentorSkills.setFacilitiesOffered("notes");
                    mentorSkills.setMentorSkillId(1);
                    mentorSkills.setRating(9);
                    mentorSkills.setTrainingdelivered(5);
                    List<MentorSkills> mentorskill = new ArrayList<>();
                    mentorskill.add(mentorSkills);
                    when(searchService.search("Angular")).thenReturn(mentorskill);
                    Integer testid = new Integer(1);
                    List<MentorSkills> testMentorSkill=searchService.search("Angular");
                    assertEquals(1, testMentorSkill.size());
                    for(MentorSkills mentorskills : testMentorSkill) {
                                    assertEquals( testid, mentorskills.getMentorSkillId());
                    }
                    verify(searchService).search("Angular");
                    
    }
    @Test
    public void testGetAll(){
                    List<MentorSkills> msList=new ArrayList<>();
                    msList=mentorSkillsRepository.findAll();
                    assertEquals( msList.isEmpty(),true);
    }
    
    @Test
    public void testGetAllSearch() throws Exception{
                                    ResultActions actions=mvc.perform(get("/search/"));
                                    actions.andExpect(status().isOk());
                                    
                    }



    


}
