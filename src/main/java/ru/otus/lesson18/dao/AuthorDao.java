package ru.otus.lesson18.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.lesson18.model.Author;


public interface AuthorDao extends JpaRepository<Author, Long> {

}
