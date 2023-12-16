package com.esprit.microservices.borrowing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;

    @Autowired
    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    public List<Borrowing> getBorrowingsByUserId(String userId) {
        return borrowingRepository.findByUserId(userId);
    }

    public List<Borrowing> getBorrowingsByBookId(String bookId) {
        return borrowingRepository.findByBookId(bookId);
    }

    public Borrowing borrowBook(String userId, String bookId) {
        Borrowing borrowing = new Borrowing();
        borrowing.setUserId(userId);
        borrowing.setBookId(bookId);
        borrowing.setBorrowDate(LocalDate.now());
        borrowing.setDeadline(LocalDate.now().plusDays(15));
        borrowing.setReturnDate(null);
        return borrowingRepository.save(borrowing);
    }

    public Borrowing returnBook(String borrowingId) {
        Borrowing borrowing = borrowingRepository.findById(borrowingId)
                .orElseThrow(() -> new RuntimeException("Borrowing not found"));

        borrowing.setReturnDate(LocalDate.now());
        borrowing.setDeadline(null);
        return borrowingRepository.save(borrowing);
    }

    public List<Borrowing> findOutdatedBorrowings(){
        LocalDate currentDate = LocalDate.now();
        return borrowingRepository.findByDeadlineBefore(currentDate);
    }
}
