package com.cop.library_book.services.impl;

import com.cop.library_book.dtos.BookRequestDto;
import com.cop.library_book.dtos.BookResponseDto;
import com.cop.library_book.entities.Book;
import com.cop.library_book.repositories.BookRepository;
import com.cop.library_book.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookResponseDto> getAllBooksWithFilter(BookRequestDto request) {
        Pageable pageable = PageRequest.of(request.getOffset(), request.getLimit(),
                request.getSortBy().equalsIgnoreCase("ASC") ? Sort.by(request.getOrderBy()).ascending() : Sort.by(request.getOrderBy()).descending());

        Page<Book> bookPage = bookRepository.findAllWithFilter(request.getCatalogId(), pageable);
        if (bookPage.hasContent()) {
            List<BookResponseDto> result = new ArrayList<>();
            bookPage
                    .getContent()
                    .forEach(d -> result.add(setEntityToDto(d)));

            return result;
        } else {
            return new ArrayList<>();
        }
    }

    private BookResponseDto setEntityToDto(Book book) {
        BookResponseDto dto = new BookResponseDto();
        dto.setBookId(book.getId());
        dto.setBookName(book.getBookName());
        dto.setCatalogName(book.getCatalog().getCatalogName());
        dto.setCatalogCode(book.getCatalog().getCatalogCode());
        dto.setTotalStock(book.getTotalStock());

        return dto;
    }
}
