package org.lesson.platform.ticket.repository;

import java.util.List;

import org.lesson.platform.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface TicketRepository extends JpaRepository <Ticket, Integer> {

	
	//metoo per cercare ticket per titolo
	public List<Ticket> findByTitle(String title);
	


}
