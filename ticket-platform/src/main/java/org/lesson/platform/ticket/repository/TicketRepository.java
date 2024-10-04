package org.lesson.platform.ticket.repository;


import org.lesson.platform.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository <Ticket, Integer>{

}
