package com.example.formacionBitboxer2;

import com.example.formacionBitboxer2.service.UsuarioService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@EntityScan("com/example/formacionBitboxer2/entities")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FormacionBitboxer2Application {

	private static final Logger log = LoggerFactory.getLogger(FormacionBitboxer2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(FormacionBitboxer2Application.class, args);
	}
}
