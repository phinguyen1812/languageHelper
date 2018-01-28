package languageHelper.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

import languageHelper.security.AppUserDetailsService;

@EnableAutoConfiguration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AppUserDetailsService appUserDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// CSRF
		http.csrf().disable();
		// le mot de passe est transmis par le header Authorization: Basic xxxx
		http.httpBasic();
		// la méthode HTTP OPTIONS doit être autorisée pour tous
		http.authorizeRequests() //
				.antMatchers(HttpMethod.OPTIONS, "/", "/**").permitAll();
		// le dossier [app] est accessible à tous
		http.authorizeRequests() //
				.antMatchers(HttpMethod.GET, "/", "/**").hasRole("USER");
		// seul le rôle USER peut utiliser l'application
		http.authorizeRequests() //
				.antMatchers("/", "/**").hasRole("USER");
		http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"));
		http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD"));
		http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers", "Authorization, X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept"));
	}

}
