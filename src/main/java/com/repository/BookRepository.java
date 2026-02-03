package com.repository;

import java.util.List;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  @Query("Select b from Book b where b.title like %:title%")
  List<Book> findAllByTitle(@Param("title") String title);

  @Query("select b from Book b where b.author like %:author%")
  List<Book> findAllByAuthor(@Param("author") String author);

  @Query("select b from Book b where b.category like %:category%")
  List<Book> findAllByCategory(@Param("category") String category);

  @Query("select b from Book b where b.totalCopies = :totalCopies")
  List<Book> findAllByTotalCopies(@Param("totalCopies") int totalCopies);

  @Query("select b from Book b where b.availableCopies = :availableCopies")
  List<Book> findAllByAvailableCopies(@Param("availableCopies") int availableCopies);

  @Query("select b from Book b where b.addedDate = :addedDate")
  List<Book> findAllByAddedDate(@Param("addedDate") LocalDate addedDate);

  @Query("select b.availableCopies from Book b where b.bookId= :id")
  Integer findAvailableCopiesByBookId(Long id);
}
