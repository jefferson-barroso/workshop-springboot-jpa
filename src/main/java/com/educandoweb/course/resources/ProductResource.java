package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController 
//notação que significa que essa classe é um recurso web que é implementado por um
//controlador REST
@RequestMapping(value = "/categories")
//dá o nome ao recurso que se deseja chamar
public class ProductResource {
	
	@Autowired
	private CategoryService service; //injeção de dep.
	
	@GetMapping 
	// indidca que método responde a uma inquisição GET do HTTP
	//metodo pra acessar usuarios
	

	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findaAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
