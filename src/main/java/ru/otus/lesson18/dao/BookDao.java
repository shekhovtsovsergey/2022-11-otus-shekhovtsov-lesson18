package ru.otus.lesson18.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.lesson18.model.Book;
import java.util.List;


public interface BookDao extends JpaRepository<Book, Long> {

    List<Book> findAll();
    Book findBookById(Long id);


}