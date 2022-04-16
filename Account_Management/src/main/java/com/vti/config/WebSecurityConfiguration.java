package com.vti.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.vti.service.IAccountService;

@Component
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private IAccountService service;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests().antMatchers(HttpMethod.GET, "/v2/api/accounts/login**").permitAll()
//				.antMatchers("/v2/api/accounts/**").hasAnyAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/v2/api/accounts/**").hasAnyAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/v2/api/accounts/*").hasAnyAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT).hasAnyAuthority("ADMIN", "MANAGER")
				.antMatchers(HttpMethod.POST).hasAnyAuthority("ADMIN", "MANAGER").anyRequest()
				.authenticated().and().httpBasic().and().csrf().disable();
	}
}