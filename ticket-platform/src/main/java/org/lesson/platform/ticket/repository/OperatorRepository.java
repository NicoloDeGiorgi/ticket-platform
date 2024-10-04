package org.lesson.platform.ticket.repository;


import org.lesson.platform.ticket.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository <Operator, Integer> {

}
