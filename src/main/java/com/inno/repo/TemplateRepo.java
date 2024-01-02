package com.inno.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inno.model.Template;

public interface TemplateRepo extends JpaRepository<Template, Integer> {
	@Query("select t from Template t where t.id= :id")
	public Template getTempalteById(Integer id);
}
