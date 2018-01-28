package languageHelper.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import languageHelper.entities.User;
import languageHelper.repositories.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userRepo.findUserByUsername(username);
		
		if (null == user) {
			throw new UsernameNotFoundException(String.format("login [%s] inexistant", username));
		}
		return new AppUserDetails(user, userRepo);
	}

}
