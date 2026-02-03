package com.service;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.BookNotFoundException;
import com.model.Book;
import com.repository.BookRepository;

@Service
public class BookService {

  @Autowired
  private BookRepository repo;
  private final String message = "Book Id is not exists !";

  public Book getBookById(Long bookId) {
    return repo.findById(bookId).orElseThrow(() -> new BookNotFoundException(message));
  }

  public List<Book> getAllBooks() {
    return repo.findAll();
  }

  public String saveSingleBook(Book book) {
    book.setAddedDate(LocalDate.now());
    repo.save(book);
    return "Book are added.";
  }

  public String saveAllBooks(List<Book> books) {
    for (Book book : books)
      book.setAddedDate(LocalDate.now());

    repo.saveAll(books);
    return "All Books are added.";
  }

  public String updateBookById(Long bookId, Book updatedBook) {
    Book oldBook = repo.findById(bookId).orElseThrow(() -> new BookNotFoundException(message));

    oldBook.setAuthor(updatedBook.getAuthor());
    oldBook.setTitle(updatedBook.getTitle());
    oldBook.setCategory(updatedBook.getCategory());
    oldBook.setTotalCopies(updatedBook.getTotalCopies());
    oldBook.setAvailableCopies(updatedBook.getAvailableCopies());
    oldBook.setAddedDate(updatedBook.getAddedDate());

    repo.save(oldBook);
    return "Book details updated.";
  }

  public String deleteBookById(Long bookId) {
    repo.findById(bookId).orElseThrow(() -> new BookNotFoundException(message));
    repo.deleteById(bookId);
    return "Book successfully deleted.";
  }

  public List<Book> getBookByTitle(String title) {
    return repo.findAllByTitle(title);
  }

  public List<Book> getBooksByAuthor(String author) {
    return repo.findAllByAuthor(author);
  }

  public List<Book> getBookByCategory(String category) {
    return repo.findAllByCategory(category);
  }

  public List<Book> getBookByTotalCopies(int totalCopies) {
    return repo.findAllByTotalCopies(totalCopies);
  }

  public List<Book> getBookByAvailableCopies(int availableCopies) {
    return repo.findAllByAvailableCopies(availableCopies);
  }

  public List<Book> getBookByAddedDate(LocalDate addedDate) {
    return repo.findAllByAddedDate(addedDate);
  }

}
