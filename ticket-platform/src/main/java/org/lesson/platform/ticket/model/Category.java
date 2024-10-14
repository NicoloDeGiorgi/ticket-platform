package org.lesson.platform.ticket.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import jakarta.validation.constraints.NotNull;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //generazione ID
	private Integer id;
	
	@NotNull
	@Column(name="name", nullable = false, unique = true) //colonna NOME, " " , univoco
	private String name;
	
	@ManyToMany(mappedBy="categories")
	private List <Ticket> tickets;

	
	//GETTER E SETTER 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	

}
