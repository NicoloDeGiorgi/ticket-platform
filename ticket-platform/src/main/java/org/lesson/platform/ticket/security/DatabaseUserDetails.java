package org.lesson.platform.ticket.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.lesson.platform.ticket.model.Role;
import org.lesson.platform.ticket.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//Tutti i metodi dell'interfaccia devono essere implementati
@SuppressWarnings("serial")
public class DatabaseUserDetails implements UserDetails {

	@SuppressWarnings("unused")
	private final Integer id;
	private final String username;
	private final String password;
	private final Set<GrantedAuthority> authorities;

	public DatabaseUserDetails(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		authorities = new HashSet<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName())); // per ogni ruolo che ha l'utente aggiugni un
																			// "authoriry"
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	@Override
	public String getPassword() {

		return this.password;
	}

	@Override
	public String getUsername() {

		return this.username;
	}

}
