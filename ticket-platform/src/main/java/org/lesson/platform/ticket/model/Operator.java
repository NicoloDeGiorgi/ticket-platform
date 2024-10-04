package org.lesson.platform.ticket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name ="operators")
public class Operator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //generazione ID
	private Integer id;
	
	@Column(name = "name", nullable = false) //colonna NOME OPERATORE, non può essere null
	private String name;
	
	@Column(name = "email", nullable = false, unique = true) //colonna EMAIL OPERATORE, " ", deve essere univoco
	private String email;
	
	//creare relazione
	// (da fare) mostrare lista ticket assegnati 
	
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
