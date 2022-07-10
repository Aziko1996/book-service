package com.azikosolutions.awsrdsspring.controller;

import com.azikosolutions.awsrdsspring.model.Book;
import com.azikosolutions.awsrdsspring.repository.BookRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/save")
    public Book saveBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/books")
    public List<Book> findBooks() {
        return bookRepository.findAll().stream().sorted(Comparator.comparing(Book::getPrice)).collect(Collectors.toList());
    }


    @SneakyThrows
    @GetMapping("/books/{id}")
    public Book findBook(@PathVariable int id) {
        return bookRepository.findById(id).orElseThrow(() -> new Exception("Book not available"));
    }

}
