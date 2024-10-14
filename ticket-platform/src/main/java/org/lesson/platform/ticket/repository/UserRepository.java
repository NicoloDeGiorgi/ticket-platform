package org.lesson.platform.ticket.repository;



import java.util.Optional;

import org.lesson.platform.ticket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	//metodo che trova un utente 
	public Optional<User> findByUsername(String username);

}
