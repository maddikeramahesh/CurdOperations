package com.bookstore.bookmarket.controller;

import java.util.Optional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookmarket.entity.Book;
import com.bookstore.bookmarket.repository.BookRepository;
import com.google.gson.Gson;

@RestController
public class BookStore {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping(path = "/userDetails")
	public @ResponseBody Iterable<Book> getAllUsers() {
		System.out.println("Book==");
		return bookRepository.findAll();
	}

	@PostMapping("/create")
	public Book create(@RequestBody Book body) {
		return bookRepository.save(body);
	}

	@PutMapping("/update/{id}")
	public Book updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
		Optional<Book> existingBookOptional = bookRepository.findById(id);

		if (existingBookOptional.isPresent()) {
			Book existingBook = existingBookOptional.get();
			existingBook.setName(updatedBook.getName());
			return bookRepository.save(existingBook);
		} else {
			return null;
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable int id) {
		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

		/*
		 * @GetMapping("/bookDetails") public String bookRigister() { String url =
		 * "jdbc:mysql://localhost:3306/Mysql"; String username = "root"; String
		 * password = "root";
		 * 
		 * try { // Register the JDBC driver Class.forName("com.mysql.cj.jdbc.Driver");
		 * 
		 * // Open a connection Connection connection = DriverManager.getConnection(url,
		 * username, password);
		 * 
		 * // Create a statement Statement statement = connection.createStatement();
		 * 
		 * // Execute a query ResultSet resultSet =
		 * statement.executeQuery("SELECT * FROM test_db.book");
		 * 
		 * // Process the result set while (resultSet.next()) { // Retrieve data int id
		 * = resultSet.getInt("no"); String name = resultSet.getString("name");
		 * 
		 * // Process data as needed System.out.println("ID: " + id + ", Name: " +
		 * name); }
		 * 
		 * // Close resources resultSet.close(); statement.close(); connection.close();
		 * } catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
		 * return "Data Received"; }
		 */

	}
}
