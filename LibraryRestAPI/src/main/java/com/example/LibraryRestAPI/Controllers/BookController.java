package com.example.LibraryRestAPI.Controllers;

import com.example.LibraryRestAPI.Domains.Book;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

@RestController
@Log

public class BookController {

    @GetMapping(path = "/books")
    public Book retrieveBook()
    {
        return Book.builder()
                .isbn("978")
                .title("The Boy WHo Lived")
                .author("JK")
                .yearPublished("2000")
                .build();
    }

    @PostMapping(path = "/books")
    public Book createBook(@RequestBody final Book book)
    {
        log.info("Got book:" + book.toString());
        return book;
    }
}
