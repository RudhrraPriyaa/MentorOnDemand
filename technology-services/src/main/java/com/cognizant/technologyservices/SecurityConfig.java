package com.cognizant.technologyservices;

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

import com.cognizant.technologyservices.security.JwtAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

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
				.antMatchers("/allSkills").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/trainee").permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest()
				.authenticated().and().addFilter(new JwtAuthorizationFilter(authenticationManager()));

	}

}
