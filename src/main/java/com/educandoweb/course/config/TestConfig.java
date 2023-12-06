package com.educandoweb.course.config;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration //fala pro spring que é uma classe exclusiva para configuração
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired //injeção de dependencia
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(1, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(2, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(1, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(2, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order( 3, Instant.parse("2019-07-22T15:21:22Z"), u1);
	 

		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	} 
	
	
}
