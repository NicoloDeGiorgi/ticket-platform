package org.lesson.platform.ticket.security;

import java.util.Optional;

import org.lesson.platform.ticket.model.User;
import org.lesson.platform.ticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override       
	public UserDetails loadUserByUsername(String username)
	throws UsernameNotFoundException { 
		
		//cercal'utenet nel database
	Optional<User> user = userRepository.findByUsername(username);
	 
	if(user.isPresent()) { // se lo trova  
		
	return new DatabaseUserDetails(user.get()); // ritorna DatabaseUserDetails che riguarda l'utente
	} else { // altrimenti lancia un'eccezione (non trova l'utente)
		
	throw new UsernameNotFoundException("Username non trovato");
	}
}

}
