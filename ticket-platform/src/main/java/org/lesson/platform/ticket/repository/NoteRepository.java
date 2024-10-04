package org.lesson.platform.ticket.repository;


import org.lesson.platform.ticket.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository <Note, Integer> {

}

