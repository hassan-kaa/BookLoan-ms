package com.esprit.microservices.borrowing;

// BorrowingController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    private final BorrowingService borrowingService;

    @Autowired
    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping
    public List<Borrowing> getAllBorrowings() {
        return borrowingService.getAllBorrowings();
    }
    @GetMapping("/outdated")
    public List<Borrowing> getOutDatedBorrowings(){
        return borrowingService.findOutdatedBorrowings();
    }

    @GetMapping("/user/{userId}")
    public List<Borrowing> getBorrowingsByUserId(@PathVariable String userId) {
        return borrowingService.getBorrowingsByUserId(userId);
    }


    @GetMapping("/book/{bookId}")
    public List<Borrowing> getBorrowingsByBookId(@PathVariable String bookId) {
        return borrowingService.getBorrowingsByBookId(bookId);
    }

    @PostMapping("/borrow/{userId}/{bookId}")
    public Borrowing borrowBook(@PathVariable String userId, @PathVariable String bookId) {
        return borrowingService.borrowBook(userId, bookId);
    }

    @PostMapping("/return/{borrowingId}")
    public Borrowing returnBook(@PathVariable String borrowingId) {
        return borrowingService.returnBook(borrowingId);
    }


}
