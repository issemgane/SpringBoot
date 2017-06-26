package com.appstude;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityFilter extends WebSecurityConfigurerAdapter  {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception{
		
//		auth.inMemoryAuthentication().withUser("admin").password("123").roles("PROF", "ADMIN");
//		auth.inMemoryAuthentication().withUser("ana").password("123").roles("PROF");
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username as principal, password as credentials , true from user where username = ?")
			.authoritiesByUsernameQuery("select user_username as principal, roles_name as role from users_roles where user_username = ?")
			.rolePrefix("ROLE_");
			
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
			.authorizeRequests()
				.antMatchers("/css/**","/fonts/**","/js/**","/images/**").permitAll()
					.anyRequest()
						.authenticated()
							.and()
						
			.formLogin()
				.loginPage("/login") //go to Login		
					.permitAll() //autoriser le formulaire		
		    .defaultSuccessUrl("/index.html")
		    .and()
		    .logout()
		    .invalidateHttpSession(true)
		    .logoutUrl("/logout")
		    .permitAll();
		
		    //.failureUrl("/error");
	}
}
