package org.lesson.platform.ticket.repository;

import org.lesson.platform.ticket.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Integer> {

}
