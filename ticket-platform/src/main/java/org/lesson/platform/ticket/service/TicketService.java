package org.lesson.platform.ticket.service;

import java.util.List;

import org.lesson.platform.ticket.model.Ticket;
import org.lesson.platform.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

	@Autowired
	private TicketRepository repository;

	public List<Ticket> findAll() {

		return repository.findAll();
	}

	public Ticket getById(Integer id) {
		return repository.findById(id).get();
	}
	
	public List<Ticket> findByTitle(String title){
		return repository.findByTitle(title);
	}

	public Ticket ceate(Ticket ticket) {
		return repository.save(ticket);

	}

	public Ticket update(Ticket ticket) {
		return repository.save(ticket);

	}

	public void deleteById(Integer id) {

		repository.deleteById(id);
	}

}
