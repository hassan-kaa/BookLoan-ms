package com.esprit.microservices.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;
    public List<Book> getAll(){
        return this.bookRepository.findAll();
    }
    public Book create(Book book){
        return this.bookRepository.save(book);
    }
    public Book getBookById(Integer id){
        return  this.bookRepository.findById(id).get();
    }
    public Book update(Integer id , Book book){

            if(this.bookRepository.findById(id).isPresent()) {
                Book existingBook = this.bookRepository.findById(id).get();
                existingBook.setTitle(book.getTitle());
                existingBook.setAuthor(book.getAuthor());
                return this.bookRepository.save(existingBook);
            }
            return null;


    }
   public String delete(Integer id){
        if(this.bookRepository.findById(id).isPresent()) {
            this.bookRepository.deleteById(id);
            return "Book Deleted !";
        }
        else {
            return "Could not find Book !";
        }

   }
}
