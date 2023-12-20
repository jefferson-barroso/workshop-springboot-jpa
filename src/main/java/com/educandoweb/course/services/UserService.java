package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.Exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public  User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public User update(long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
