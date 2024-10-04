package org.lesson.platform.ticket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name ="tickets") //nome della tabella
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //generazione ID
	private Integer id;
	
	@Column(name = "title", nullable = false) //colonna TITOLO, non può essere null
	private String title;
	
	@Column(name = "details", nullable = false, length = 500) //colonna DETTAGLI DEL TICKET, " ", lunghezza max
	private String details;
	
	@Column(name = "state", nullable = false) //colonna STATO DEL TICKET(es. da fare, in corso, completato), " "
	private String state;
	
	@Column (name = "operatorAssigned") //operatore  a cui è asseganto il ticket
	private String operatorAssigned;
	
	//creare relazione
	
	//GETTER E SETTER

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
 
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOperatorAssigned() {
		return operatorAssigned;
	}

	public void setOperatorAssigned(String operatorAssigned) {
		this.operatorAssigned = operatorAssigned;
	}
	
}
