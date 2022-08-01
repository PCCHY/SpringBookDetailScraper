package com.example.library.modelDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.library.model.Book;

@Repository
public class BookDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
//	List<Book> findAll(){
//		static int isbnOffset = 0;
//		String isbn = "10000" + isbnOffset++;
//		String title = "Harry potter";
//		String publisher = "JK Rowling";
//		String cover = "Green";
//		String pages = "400";
//		String available = "No";
//		
//		return jdbcTemplate.query(String.format(insertQuery, isbn, title, cover, publisher, pages, available), new BeanPropertyRowMapper(Book.class) )
//	}
	
	public int insertBook(Book book) {
		String insertQuery = "insert into book(isbn, title, cover, publisher, pages, available)"
				+ " values (?,?,?,?,?,?);";
		return jdbcTemplate.update(insertQuery, new Object[] {book.getISBN(), book.getTitle(), book.getCover(), book.getPublisher(), book.getPages(), book.getAvailable()});
	}
}
