package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Book;
import com.service.BookService;

@RestController
@RequestMapping("/lms/admin")
public class AdminController {

  @Autowired
  private BookService service;

  // ----------------------------------------------- GET

  @GetMapping("")
  public ResponseEntity<Map<String, String>> adminSlashPage() {
    return ResponseEntity.ok(Map.of("message", "Welcome Sir/Mam'a"));
  }

  // ----------------------------------------------- POST

  // add single book
  @PostMapping("/addbook")
  public ResponseEntity<Map<String, String>> addSingleBook(@RequestBody Book book) {
    return ResponseEntity.ok(Map.of("message", service.saveSingleBook(book)));
  }

  // add list of books
  @PostMapping("/addallbooks")
  public ResponseEntity<Map<String, String>> addAllBooks(@RequestBody List<Book> books) {
    return ResponseEntity.ok(Map.of("message", service.saveAllBooks(books)));
  }

  // ----------------------------------------------- PUT

  @PutMapping("/update/{id}")
  public ResponseEntity<Map<String, String>> updateBookById(@PathVariable("id") Long bookId, @RequestBody Book book) {
    return ResponseEntity.ok(Map.of("message",service.updateBookById(bookId, book)));
  }

  // ----------------------------------------------- DELETE

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Map<String, String>> deleteBookById(@PathVariable("id") Long bookId) {
    return ResponseEntity.ok(Map.of("message",service.deleteBookById(bookId)));
  }
}
