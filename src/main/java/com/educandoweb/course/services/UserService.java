package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired //injeção de dependencia
	private UserRepository repository;
	
	//método para retornar todos usuarios do BD
	//feita na camada de serviços que repassa para o BD
	public List<User> findaAll(){
		return repository.findAll();
	}
	
	//método para retornar usuarios por id
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
}
