package ru.otus.lesson18.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.lesson18.model.Genre;


public interface GenreDao extends JpaRepository<Genre, Long> {

}