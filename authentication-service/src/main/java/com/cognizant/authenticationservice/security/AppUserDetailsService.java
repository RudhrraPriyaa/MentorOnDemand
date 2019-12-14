package com.cognizant.authenticationservice.security;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservice.SecurityConfig;
import com.cognizant.authenticationservice.model.Mentor;
import com.cognizant.authenticationservice.model.MentorSkills;
import com.cognizant.authenticationservice.model.Role;
import com.cognizant.authenticationservice.model.Skills;
import com.cognizant.authenticationservice.model.Trainee;
import com.cognizant.authenticationservice.model.User;
import com.cognizant.authenticationservice.repository.MentorRepository;
import com.cognizant.authenticationservice.repository.MentorSkillsRepository;
import com.cognizant.authenticationservice.repository.RoleRepository;
import com.cognizant.authenticationservice.repository.SkillsRepository;
import com.cognizant.authenticationservice.repository.TraineeRepository;
import com.cognizant.authenticationservice.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	MentorRepository mentorRepository;
	
	@Autowired
	TraineeRepository traineeRepository;
	
	@Autowired
	SkillsRepository skillsRepository;
	
	@Autowired
	MentorSkillsRepository mentorSkillsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Exception user name not found");
		} else {
			AppUser appUser = new AppUser(user);
			System.err.println(appUser);
			return appUser;
		}

	}

	public String signupMentor(Mentor mentorList) {
	System.out.println("hi");
	Mentor mentor=mentorRepository.findByUsername(mentorList.getMentorName());
	if (mentor==null) {
		User user=new User();
		user.setUserName(mentorList.getMentorName());
		user.setPassword(passwordEncoder().encode(mentorList.getPassword()));
		Role role=roleRepository.findByName("mentor");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRoleList(roles);
		userRepository.save(user);
		mentorList.setPassword(passwordEncoder().encode(mentorList.getPassword()));
		mentorRepository.save(mentorList);
		return "true";
	}
	return "false";
}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public String signupTrainee(Trainee traineelist) {
		Trainee trainee=traineeRepository.findByUsername(traineelist.getTraineeName());
		if (trainee==null) {
			User user=new User();
			user.setUserName(traineelist.getTraineeName());
			user.setPassword(passwordEncoder().encode(traineelist.getPassword()));
			Role role=roleRepository.findByName("trainee");
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			user.setRoleList(roles);
			userRepository.save(user);
			traineelist.setPassword(passwordEncoder().encode(traineelist.getPassword()));
			traineeRepository.save(traineelist);
			return "true";
		}
		return "false";
	}

	public void addSkill(String mentorName,String skillName,MentorSkills mentorSkills)  {
        
	       Skills skills=skillsRepository.findBySkillName(skillName);
	              Mentor mentor=mentorRepository.findByUsername(mentorName);
	              mentorSkills.setMentorId(mentor);
	              mentorSkills.setSkillId(skills);
	              Set<MentorSkills> list=mentor.getMentorSkillsSet();
	              list.add(mentorSkills);
	              mentor.setMentorSkillsSet(list);
	              mentorRepository.save(mentor);
	              mentorSkillsRepository.save(mentorSkills);

	              }

	
}
