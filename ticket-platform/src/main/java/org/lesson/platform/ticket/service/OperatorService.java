package org.lesson.platform.ticket.service;

import java.util.List;
import org.lesson.platform.ticket.model.Operator;
import org.lesson.platform.ticket.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatorService {

	@Autowired
	private OperatorRepository repository;

	public List<Operator> findAll() {
		return repository.findAll();
	}

}
