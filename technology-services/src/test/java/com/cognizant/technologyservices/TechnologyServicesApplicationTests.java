package com.cognizant.technologyservices;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.technologyservices.model.Skills;
import com.cognizant.technologyservices.repository.SkillsRepository;
import com.cognizant.technologyservices.service.SkillsService;

@SpringBootTest
public class TechnologyServicesApplicationTests {

    @Mock
    SkillsService technologyService;
    
    @Mock
    SkillsRepository skillsRepository;
    
    @Before
    public void init() {
                    MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getTechnologies() {
    
                    Skills tech=new Skills();
                    tech.setDuration("123");
                    tech.setId(1);
                    tech.setPrerequites("Java");
                    tech.setSkillName("spring");
                    tech.setTableOfContents("few syntax on java");
                    
                    
                    
                    List<Skills> technology = new ArrayList<>();
                    technology.add(tech);
                    when(skillsRepository.findAll()).thenReturn(technology);
                    Integer ids=new Integer(1);
                    //test
                    List<Skills> testTech=skillsRepository.findAll();
                    assertEquals(1, testTech.size());
                    for(Skills techs : testTech) {
                                    assertEquals(ids, techs.getId());
                    }
                    
                    verify(skillsRepository).findAll();
    }


}
