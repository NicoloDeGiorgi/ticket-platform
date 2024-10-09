package org.lesson.platform.ticket.controller;

import java.util.List;

import org.lesson.platform.ticket.model.Ticket;
import org.lesson.platform.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/tickets")
public class TicketController {

	
	@Autowired
	private TicketRepository repository;
	
	
	// INDEX
	@GetMapping()
	public String index(Model model){
		List<Ticket> tickets = repository.findAll();
		model.addAttribute("tickets", tickets);
		
		return "/tickets/index";
	}


	// SHOW
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("ticket", repository.findById(id).get());
		
		return "/tickets/show";
	}

    // CREATE
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("ticket", new Ticket());
		
		return "/tickets/create";
	}
	
	//STORE
	@PostMapping("/create")
	public String store(
			//Validazione
	@Valid @ModelAttribute("ticket") Ticket formTicket,
	BindingResult bindingResult,
	Model model, RedirectAttributes redirectAttributes){
	if(bindingResult.hasErrors()) {
	return "/tickets/create";
	}                            //se ci sono errori "torna indetro" altrimenti salva
	repository.save(formTicket);
	
	redirectAttributes.addFlashAttribute("seccessMessage", "Ticket" + formTicket.getTitle() +" è stato creato con successo!");

	
	return "redirect:/tickets"; // ritorna alla index
	}
	
	// EDIT
	@GetMapping("/edit/{id}") // cerchiamo il ticket e lo inserisco nel modello
	public String edit(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("ticket", repository.findById(id).get());
		
		return "tickets/edit";
	}

	// UPDATE
	@PostMapping("/edit/{id}")
	public String update(
			// Validazione
			@Valid @ModelAttribute("ticket") Ticket UpdateFormTicket,
			BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "/tickets/edit";
		} // se ci sono errori "torna indetro" altrimenti salva
		repository.save(UpdateFormTicket);
		
		redirectAttributes.addFlashAttribute("seccessMessage", "Ticket" + UpdateFormTicket.getTitle() +" è stato aggiornato con successo!");

		
		return "redirect:/tickets"; // ritorna alla index
	}
	
	// DELETE
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id,
			RedirectAttributes redirectAttributes) {
		repository.deleteById(id); //prendo la repo, trovo il tickets attraverso id e cancello dal database
		
		 redirectAttributes.addFlashAttribute("seccessMessage", "Ticket con id" + id +" è stato eliminato con successo!");
		
		return "redirect:/tickets"; // ritorna alla index
	}

}
