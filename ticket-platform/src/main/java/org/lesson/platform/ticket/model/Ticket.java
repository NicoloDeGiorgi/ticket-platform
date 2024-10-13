package org.lesson.platform.ticket.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tickets") // nome della tabella
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // generazione ID
	private Integer id;

	
	@Size(min = 5, max = 240)
	@NotEmpty
	@Column(name = "title", nullable = false) // colonna TITOLO, non può essere null
	private String title;

	
	@Size(min = 2, max = 240)
	@Column(name = "details", nullable = false, length = 500) // colonna DETTAGLI DEL TICKET, " ", lunghezza max
	private String details;

	// ENUM utilizzato per usufruire dei valori costanti scelti in precedenza
	// :DA_FARE, IN_CORSO, COMPLETATO
	@Enumerated(EnumType.STRING)
	private StatoTicket state;
	
	@Size(min=2 , max=250)
	@Column (name = "operator") //operatore  a cui è asseganto il ticket
	private String operator;

	@Size(min = 2, max = 250)
	@Column(name = "categoria")
	private String categoria;

	// RELAZIONE CON LE NOTE fa riferimento con la entità 'ticket'
	@OneToMany(mappedBy = "ticket", cascade = { CascadeType.REMOVE })
	private List<Note> notes;

	// GETTER E SETTER

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

	public StatoTicket getState() {
		return state;
	}

	public void setState(StatoTicket state) {
		this.state = state;
	}

	
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategory(String categoria) {
		this.categoria = categoria;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

}
	


