package com.cop.library_book.services;

import com.cop.library_book.dtos.BookRequestDto;
import com.cop.library_book.dtos.BookResponseDto;

import java.util.List;

public interface BookService {
    List<BookResponseDto> getAllBooksWithFilter(BookRequestDto request);
}
