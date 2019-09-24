package com.sliit.ssd.security.oauthfacebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import java.security.Principal;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class OauthFacebookApplication extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpsecurity) throws Exception {
		httpsecurity

				.antMatcher("/**")
				.authorizeRequests()
				.antMatchers("/", "/login**", "/webjars/**")
				.permitAll()
				.anyRequest()
				.authenticated();
	}

	@RequestMapping("/loggeduser")
	public Principal user(Principal principal) {
		return principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(OauthFacebookApplication.class, args);
	}

}
