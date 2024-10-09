package org.lesson.platform.ticket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name ="tickets") //nome della tabella
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //generazione ID
	private Integer id;
	
	@NotNull
	@Size(min=5 , max=240)
	@NotEmpty
	@Column(name = "title", nullable = false) //colonna TITOLO, non può essere null
	private String title;
	
	@NotNull
	@Size(min=2 , max=240)
	@Column(name = "details", nullable = false, length = 500) //colonna DETTAGLI DEL TICKET, " ", lunghezza max
	private String details;
	
   
	@Column(name="state")
	private String state;
	
	@NotNull
	@Size(min=2 , max=250)
	@Column (name = "operator") //operatore  a cui è asseganto il ticket
	private String operator;

	
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

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}
	
	
	
	


