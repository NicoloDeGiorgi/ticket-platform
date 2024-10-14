package org.lesson.platform.ticket.service;

import java.util.List;

import org.lesson.platform.ticket.model.Note;
import org.lesson.platform.ticket.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

	@Autowired
	private NoteRepository repository;

	// index //ordinati per data
	public List<Note> findAllSortedByCreatedAt() {
		return repository.findAll(Sort.by("createdAt"));
	}

	// create
	public Note create(Note note) {
		return repository.save(note);
	}
}
