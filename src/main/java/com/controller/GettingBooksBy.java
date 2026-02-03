package com.controller;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Book;
import com.service.BookService;

@RestController
@RequestMapping({
    "/lms/admin/getbooks",
    "/lms/getbooks"
})
public class GettingBooksBy {

  @Autowired
  private BookService service;

  @GetMapping("")
  public List<Book> getAllBooks() {
    return service.getAllBooks();
  }

  // get book by id
  @GetMapping("/id/{id}")
  public ResponseEntity<Book> getBookById(@PathVariable("id") Long bookId) {
    return ResponseEntity.ok(service.getBookById(bookId));
  }

  // get book by title
  @GetMapping("/title/{title}")
  public ResponseEntity<List<Book>> getBookBytitle(@PathVariable("title") String title) {
    List<Book> books = service.getBookByTitle(title);
    return books.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(books);
  }

  // get book by author
  @GetMapping("/author/{author}")
  public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable("author") String author) {
    List<Book> books = service.getBooksByAuthor(author);
    return books.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(books);
  }

  // get book by category
  @GetMapping("/category/{category}")
  public ResponseEntity<List<Book>> getBookByCategory(@PathVariable("category") String category) {
    List<Book> books = service.getBookByCategory(category);
    return books.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(books);
  }

  // get book by totalCopies
  @GetMapping("/totalcopies/{totalCopies}")
  public ResponseEntity<List<Book>> getBookByTotalCopies(@PathVariable("totalCopies") int totalCopies) {
    List<Book> books = service.getBookByTotalCopies(totalCopies);
    return books.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(books);
  }

  // get book by availableCopies
  @GetMapping("/availablecopies/{availableCopies}")
  public ResponseEntity<List<Book>> getBookByAvailableCopies(@PathVariable("availableCopies") int availableCopies) {
    List<Book> books = service.getBookByAvailableCopies(availableCopies);
    return books.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(books);
  }

  // get book by addedDate
  @GetMapping("/addeddate/{addedDate}")
  public ResponseEntity<List<Book>> getBookByAddedDate(@PathVariable("addedDate") LocalDate addedDate) {
    List<Book> books = service.getBookByAddedDate(addedDate);
    return books.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(books);
  }

}
