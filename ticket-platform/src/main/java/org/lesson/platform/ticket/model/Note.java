package org.lesson.platform.ticket.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name ="notes")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //generazione ID
	private Integer id;
	
	@Column(name = "author", nullable = false) //colonna AUTORE, non può essere null
	private String author;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "textField", nullable = false) //colonna CAMPO DI TESTO, " "
	private String text;

	public Integer getId() {
		return id;
	}

	//creare relazione
	
	//GETTER E SETTER
	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAutore(String author) {
		this.author = author;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	//creare relazione

}
