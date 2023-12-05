package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration //fala pro spring que é uma classe exclusiva para configuração
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired //injeção de dependencia
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(1, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		
		User u2 = new User(2, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	} 
	
	
}
