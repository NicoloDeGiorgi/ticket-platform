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
	//index
	public List<Ticket> findByTitle(String title){
		return repository.findByTitle(title);
	}
    //create
	public Ticket create(Ticket ticket) {
		return repository.save(ticket);

	}
    //edit
	public Ticket update(Ticket ticket) {
		return repository.save(ticket);

	}
	//show
	public Ticket getById(Integer id) {
		return repository.findById(id).get();
	}
    //delete
	public void deleteById(Integer id) {

		repository.deleteById(id);
	}


}
