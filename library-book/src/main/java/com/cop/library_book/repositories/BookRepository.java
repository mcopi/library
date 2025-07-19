package com.cop.library_book.repositories;

import com.cop.library_book.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    @Query("SELECT b FROM Book b " +
            "WHERE b.totalStock > 0 AND " +
            "(:catalogId IS NULL OR b.catalog.id = :catalogId)")
    Page<Book> findAllWithFilter(String catalogId, Pageable pageable);
}
