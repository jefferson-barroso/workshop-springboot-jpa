package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController 
//notação que significa que essa classe é um recurso web que é implementado por um
//controlador REST
@RequestMapping(value = "/users")
//dá o nome ao recurso que se deseja chamar
public class UserResource {
	@GetMapping 
	// indidca que método responde a uma inquisição GET do HTTP
	//metodo pra acessar usuarios
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@maria.com", "99999999", "123");
		return ResponseEntity.ok().body(u);
	}

}
