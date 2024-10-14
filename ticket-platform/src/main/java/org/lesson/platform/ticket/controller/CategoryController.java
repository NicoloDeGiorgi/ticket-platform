package org.lesson.platform.ticket.controller;

import org.lesson.platform.ticket.model.Category;
import org.lesson.platform.ticket.service.CategoryService;
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
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	//index
@GetMapping()
public String index(Model model) {
	
	model.addAttribute("categories", service.findAll());
	return "/categories/index";
	
}

//CREATE
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("category", new Category());

		return "/categories/create";
	}

	// STORE
	@PostMapping("/create")
	public String store(
			// Validazione
			@Valid @ModelAttribute("category") Category formCategory,
			BindingResult bindingResult, 
			Model model) {
		if (bindingResult.hasErrors()) {
			return "/categories/create";
		} // se ci sono errori "torna indetro" altrimenti salva
		service.create(formCategory);
		
		return "redirect:/categories";

}
}
