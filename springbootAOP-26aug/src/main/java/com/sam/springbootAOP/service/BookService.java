package com.sam.springbootAOP.service;

import org.springframework.context.annotation.Configuration;

import com.sam.springbootAOP.model.Book;

@Configuration
public class BookService {

	public Book addBook(String title, String bookId) {
		Book book = new Book(bookId, title);
		System.out.println("Inside add Book");
		System.out.println("Creating a book " + title + " " + bookId);
		 return book;
	}

	public void deleteBook(String bookId) {
		System.out.println("Deleting book with id : + bookId");
	}

	public void newBook(String title, String bookId) {
		System.out.println("Inside new Book");
		System.out.println("Have you read the new book with title : " + title + " id : " + bookId);	
	}

	
}
