package com.cognizant.trainingservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.trainingservice.security.AppUserDetailsService;
import com.cognizant.trainingservice.security.JwtAuthorizationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Started");
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/users").permitAll()
				.antMatchers("/authentication").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/mentor").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/proposal/{mentorName}/{traineeName}/{techName}").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/proposal/pending/{mentorName}").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/mentor/{mentorName}/{skillName}").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/proposal/decline/{traineeId}").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/proposal/accepted/{trainingId}").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/proposal/completed/{traineeId}").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/proposal/pay/{traineeId}").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/trainee").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest()
				.authenticated().and().addFilter(new JwtAuthorizationFilter(authenticationManager()));
	}
	
}
