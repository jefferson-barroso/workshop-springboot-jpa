package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired //injeção de dependencia
	private ProductRepository repository;
	
	//método para retornar todos usuarios do BD
	//feita na camada de serviços que repassa para o BD
	public List<Product> findaAll(){
		return repository.findAll();
	}
	
	//método para retornar usuarios por id
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
