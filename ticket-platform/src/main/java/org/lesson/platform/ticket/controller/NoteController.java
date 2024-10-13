package org.lesson.platform.ticket.controller;

import org.lesson.platform.ticket.model.Note;
import org.lesson.platform.ticket.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/notes")
public class NoteController {
	
	@Autowired
	private NoteService service;
	
@GetMapping()
public String index(Model model) {
	
	model.addAttribute("notes", service.findAllSortByCreatedAt());
	
	return "notes/index";
	
}

@PostMapping("/create")
public String store(
		// Validazione
		@Valid @ModelAttribute("note") Note formNote,
		BindingResult bindingResult,
		Model model) {
	if (bindingResult.hasErrors()) { // se ci sono errori "torna indetro"
		return "/notes/create"; 
	}
	service.create(formNote);	 //altrimenti salva e crea la formNote
	
	return "redirect:/notes/show" + formNote.getTicket().getId(); // ritorna alla show prendendo l'id della nota
}
  
}



		
		
		
		
		