package com.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcrud.model.Books;
import com.springcrud.service.BooksService;

@RestController
@RequestMapping
@Controller
public class BooksController {
	
	@Autowired(required=true)
	BooksService booksService;
	
	@GetMapping("/book")
	private List<Books> getAlBooks(){
		return booksService.getAllBooks();
	}
	
	@GetMapping("/book/{bookid}")  
	private Books getBooks(@PathVariable("bookid") int bookid)   
	{  
	return booksService.getBooksById(bookid);  
	}  
	//creating a delete mapping that deletes a specified book  
	@DeleteMapping("/book/{bookid}")  
	private void deleteBook(@PathVariable("bookid") int bookid)   
	{  
	booksService.delete(bookid);  
	}  
	//creating post mapping that post the book detail in the database  
	@PostMapping("/books")  
	private int saveBook(@RequestBody Books books)   
	{  
	booksService.saveOrUpdate(books);  
	return books.getBookid();  
	}  
	//creating put mapping that updates the book detail   
	@PutMapping("/books")  
	private Books update(@RequestBody Books books)   
	{  
	booksService.saveOrUpdate(books);  
	return books;  
	}  
	  
}
