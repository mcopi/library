package com.cop.library_book.controllers;

import com.cop.library_book.dtos.BookRequestDto;
import com.cop.library_book.dtos.BookResponseDto;
import com.cop.library_book.services.BookService;
import com.cop.library_shared.dtos.SuccessResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("getAllBooks")
    public ResponseEntity<SuccessResponseDto<List<BookResponseDto>>> getAllBooksWithFilter(@RequestBody BookRequestDto request) {
        return ResponseEntity
                .ok()
                .body(new SuccessResponseDto<>(bookService.getAllBooksWithFilter(request), "Succeed"));
    }
}
