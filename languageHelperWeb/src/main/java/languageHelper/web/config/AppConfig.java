package languageHelper.web.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import languageHelper.config.DomainAndPersistenceConfig;


@EnableJpaRepositories(basePackages = { "languageHelper.repositories"})
@EnableAutoConfiguration
@ComponentScan(basePackages = { "languageHelper" })
@EntityScan(basePackages = { "languageHelper.entities","languageHelper.security"})
@EnableTransactionManagement
@EnableWebMvc 
@Import({ DomainAndPersistenceConfig.class, WebConfig.class,WebSecurityConfig.class })
public class AppConfig{

	

}
