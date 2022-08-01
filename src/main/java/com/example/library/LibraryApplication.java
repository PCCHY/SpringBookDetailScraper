package com.example.library;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.library.model.Book;
import com.example.library.modelDao.BookDao;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BookDao bookDao;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String isbn = "10098";
		String title = "Harry potter";
		String publisher = "JK Rowling";
		String cover = "Green";
		String pages = "400";
		String available = "No";
		Book book = new Book(isbn, title, cover, publisher, pages, available);
		bookDao.insertBook(book);
	}

}
