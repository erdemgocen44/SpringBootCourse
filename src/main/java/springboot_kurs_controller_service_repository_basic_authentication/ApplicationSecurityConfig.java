package springboot_kurs_controller_service_repository_basic_authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","index","/css/*","/js/*").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();// Basic authentication olmak istiorum
					// demek, her harekette her istekte
					// username ve password kontrol edilecek

	}

	@Override
	@Bean//Bean Configuration ile beraber çalışır.İkiside olmak zorunda
	protected UserDetailsService userDetailsService() {
	User student=	User.builder().username("techproed").password("12345").roles("STUDENT").build();
	}

}
