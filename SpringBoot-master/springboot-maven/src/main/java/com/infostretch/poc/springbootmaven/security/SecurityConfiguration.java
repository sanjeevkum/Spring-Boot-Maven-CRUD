package com.infostretch.poc.springbootmaven.security;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Setting configuration on the auth subject
		auth.inMemoryAuthentication() //name,passwor,role present in memory
		.withUser("abc")
		.password("abc")
		.roles("USER")
		.and()  //Add Multiple user using .and()
		.withUser("xyz")
		.password("xyz")
		.roles("ADMIN");
	}


	@Bean
	public PasswordEncoder getPasswordEncoder() 
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/employees/**")// /** indicates all path in current level and any nested levels below this
		.hasRole("ADMIN") // follow Top restrictive to least restrictive
		.antMatchers("/","static/css", "static/js").permitAll() // for static page
		.antMatchers("/").permitAll()
		.and()
		.formLogin();//form based login
	}
}*/