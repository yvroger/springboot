package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.book.repo.BookRepository;
import com.example.demo.model.book.Book;
import com.example.demo.model.user.User;
import com.example.demo.user.repo.UserRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class SpringbootConnectMultipeDsApplication {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void AddDataToDB() {
		userRepository.saveAll(Stream.of(new User(100, "Yves"), new User(200, "Michel"))
				.collect(Collectors.toList()));
		bookRepository.saveAll(Stream.of(new Book(111, "Petit Prince"), new User(222, "Artificial Intelligence"))
				.collect(Collectors.toList()));
	}
	
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return userRepository.findAll();
	}

	@GetMapping("/getBooks")
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootConnectMultipeDsApplication.class, args);
	}

}
