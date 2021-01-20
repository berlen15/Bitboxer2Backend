package com.example.formacionBitboxer2;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EntityScan("com/example/formacionBitboxer2/entities")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FormacionBitboxer2Application {

	//private static final Logger log = LoggerFactory.getLogger(FormacionBitboxer2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(FormacionBitboxer2Application.class, args);
	}


	@Configuration
	@EnableWebSecurity
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		@Autowired
		UserDetailsService userDetailsService;

		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			return bCryptPasswordEncoder;
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers("/admin").hasAuthority("ADMIN")
					.antMatchers("/user").hasAuthority("USER")
					.antMatchers(HttpMethod.POST, "/login").permitAll()
					.antMatchers(HttpMethod.GET, "/articulos").permitAll()
					.anyRequest().authenticated();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		}

	}
}
