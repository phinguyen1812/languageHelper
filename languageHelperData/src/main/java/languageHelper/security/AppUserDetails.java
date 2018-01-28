package languageHelper.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import languageHelper.entities.User;
import languageHelper.repositories.UserRepository;

public class AppUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	private User user;
	private UserRepository userRepo;

	public AppUserDetails(User user, UserRepository userRepo) {
		this.user = user;
		this.userRepo = userRepo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		
	    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		return authorities;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
