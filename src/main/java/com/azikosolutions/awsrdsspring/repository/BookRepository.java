package com.azikosolutions.awsrdsspring.repository;

import com.azikosolutions.awsrdsspring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
