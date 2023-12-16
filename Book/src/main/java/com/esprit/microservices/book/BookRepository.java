package com.esprit.microservices.book;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Integer> {

}
