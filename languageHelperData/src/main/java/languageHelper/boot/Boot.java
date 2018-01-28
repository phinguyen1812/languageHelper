package languageHelper.boot;



import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.google.common.collect.Lists;

import languageHelper.config.DomainAndPersistenceConfig;
import languageHelper.entities.User;
import languageHelper.repositories.UserRepository;


public class Boot {
	// le boot
	public static void main(String[] args) {
//		// on prépare la configuration
//		SpringApplication app = new SpringApplication(DomainAndPersistenceConfig.class);
//		app.setLogStartupInfo(false);
//		// on la lance
//		ConfigurableApplicationContext context = app.run(args);
//		// métier
//		UserRepository user = context.getBean(UserRepository.class);
//		try {
//			
//			//display("Liste des users", user.getUserByID(1L));
//			ArrayList<User> liste = Lists.newArrayList(user.getUserByID(1L));
//			for (User user2 : liste) {
//				System.out.println(user2.getFirstname() +user2.getName());
//			}
//			
//		} catch (Exception ex) {
//			System.out.println("Exception : " + ex.getCause());
//		}
//		// fermeture du contexte Spring
//		context.close();
//	}
//
//	// méthode utilitaire - affiche les éléments d'une collection
//	private static <T> void display(String message, Iterable<T> elements) {
//		System.out.println(message);
//		for (T element : elements) {
//			System.out.println(element);
//		}
	}

}
