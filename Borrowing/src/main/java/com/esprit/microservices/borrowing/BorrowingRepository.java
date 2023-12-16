package com.esprit.microservices.borrowing;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BorrowingRepository extends MongoRepository<Borrowing, String> {

    List<Borrowing> findByUserId(String userId);

    List<Borrowing> findByBookId(String bookId);

    List<Borrowing> findByDeadlineBefore(LocalDate date);

}


