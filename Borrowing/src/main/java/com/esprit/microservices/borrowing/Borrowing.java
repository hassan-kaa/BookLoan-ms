package com.esprit.microservices.borrowing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "borrowings")
public class Borrowing {

    @Id
    private String id;
    private String userId; // on peut creer l'entite et services utilisateur apres
    private String bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private LocalDate deadline;

}
