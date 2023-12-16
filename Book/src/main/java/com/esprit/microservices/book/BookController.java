package com.esprit.microservices.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private  String title="Hello, i;m the book Micro Service";

    @GetMapping("/hello")
    public String sayHello(){
        return title;
    }
    private final BookService bookService;
    @GetMapping
    public List<Book> getAllBooks(){
        return this.bookService.getAll();
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id){
        return this.bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Integer id){
        return new ResponseEntity<>(bookService.delete(id),HttpStatus.OK);
    }
    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.create(book), HttpStatus.CREATED);
    }
    @PostMapping(value = "/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Book> update(@PathVariable Integer id , @RequestBody Book book) {
        return new ResponseEntity<>(bookService.update(id,book), HttpStatus.OK);
    }


}

