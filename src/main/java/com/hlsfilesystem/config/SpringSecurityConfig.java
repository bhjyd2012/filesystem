package com.hlsfilesystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication()
	        .passwordEncoder(new BCryptPasswordEncoder())
	        .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("user");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/css/**")
		.antMatchers("/img/**")
		.antMatchers("/js/**")
		.antMatchers("/images/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/user/**").authenticated()
		.anyRequest().permitAll()
        .and()
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/index")
        .failureUrl("/login?error")
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
		.deleteCookies("remember-me").permitAll();
		http.rememberMe().rememberMeParameter("remember-me");
	}
	
}
