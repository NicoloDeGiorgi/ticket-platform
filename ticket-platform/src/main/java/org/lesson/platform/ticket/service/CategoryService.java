package org.lesson.platform.ticket.service;

import java.util.List;

import org.lesson.platform.ticket.model.Category;
import org.lesson.platform.ticket.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	// index
	public List<Category> findAll() {
		return repository.findAll();
	}

	// create
	public Category create(Category category) {
		return repository.save(category);
	}

	// edit
	public Category ipdate(Category category) {
		return repository.save(category);
	}

	// show
	public Category getByid(Integer id) {
		return repository.findById(id).get();
	}
}
