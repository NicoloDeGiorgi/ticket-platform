package org.lesson.platform.ticket.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name ="operators")
public class Operator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //generazione ID
	private Integer id;
	
	@NotNull
	@NotEmpty
	@Column(name = "name", nullable = false) //colonna NOME OPERATORE, non può essere null
	private String name;
	
	@NotNull
	@NotEmpty
	@Size(max=150)
	@Column(name = "email", nullable = false, unique = true) //colonna EMAIL OPERATORE, " ", deve essere univoco
	private String email;
	
	//RELAZIONE CON I TICKET fa riferimento con la entità 'operatore'
	@OneToMany(mappedBy = "operator", cascade = { CascadeType.REMOVE })
	private List<Ticket> tickets;

	 
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
