package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired //injeção de dependencia
	private CategoryRepository repository;
	
	//método para retornar todos usuarios do BD
	//feita na camada de serviços que repassa para o BD
	public List<Category> findaAll(){
		return repository.findAll();
	}
	
	//método para retornar usuarios por id
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
}
