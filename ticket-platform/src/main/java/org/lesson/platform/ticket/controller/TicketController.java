package org.lesson.platform.ticket.controller;


import java.time.LocalDate;

import java.util.List;


import org.lesson.platform.ticket.model.Note;
import org.lesson.platform.ticket.model.Ticket;
import org.lesson.platform.ticket.service.CategoryService;
import org.lesson.platform.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService service;
	
	@Autowired
	private CategoryService categoryService;
	
	// INDEX
	@GetMapping() // ricerca libro per titolo
	public String index(Model model, @RequestParam(name = "title", required = false) String title) {

		List<Ticket> tickets;

		if (title != null) { // condizione : se title non è null trova il ticket
			model.addAttribute("ticketTitle", title);
			tickets = service.findByTitle(title);

		} else {

			tickets = service.findAll();
		}
		model.addAttribute("tickets", tickets);

		return "/tickets/index";
	}

	// SHOW
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("ticket", service.getById(id));

		return "/tickets/show";
	}

	// CREATE
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("ticket", new Ticket());//aggiungo nuovo ticket
		model.addAttribute("categories", categoryService.findAll());//aggiungo nuova categoria

		return "/tickets/create";
	}

	// STORE
	@PostMapping("/create")
	public String store(
			// Validazione
			@Valid @ModelAttribute("ticket") Ticket formTicket,
			BindingResult bindingResult, 
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", categoryService.findAll());
			return "/tickets/create";
		} // se ci sono errori "torna indetro" altrimenti salva
		service.create(formTicket);

		return "redirect:/tickets"; // ritorna alla index
	}

	// EDIT
	@GetMapping("/edit/{id}") // cerchiamo il ticket e lo inserisco nel modello
	public String edit(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("ticket", service.getById(id));

		return "tickets/edit";
	}

	// UPDATE
	@PostMapping("/edit/{id}")
	public String update(
			// Validazione
			@Valid @ModelAttribute("ticket") Ticket formUpdateTicket,
			BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "/tickets/edit";
		} // se ci sono errori "torna indetro" altrimenti salva
		service.update(formUpdateTicket);

		return "redirect:/tickets"; // ritorna alla index
	}

	// DELETE
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		service.deleteById(id); // prendo la repo, trovo il tickets attraverso id e cancello dal database

		return "redirect:/tickets"; // ritorna alla index
	}

     //NOTECREATE
	@GetMapping("/{id}/note")
	public String note(@PathVariable("id") Integer id, Model model) {
		Note note = new Note();
		note.setCreatedAt(LocalDate.now()); //data
		note.setTicket(service.getById(id));  // inserisco il ticket della nota
		model.addAttribute("note", note);

		return "/notes/create";
	}

}
