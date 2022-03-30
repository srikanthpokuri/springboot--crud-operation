package com.springcrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springcrud.model.Books;

@Repository
public interface BooksRepositry extends CrudRepository<Books, Integer> {
	
	

}
