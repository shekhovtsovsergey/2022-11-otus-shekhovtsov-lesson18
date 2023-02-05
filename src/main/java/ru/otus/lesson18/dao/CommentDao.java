package ru.otus.lesson18.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.lesson18.model.Book;
import ru.otus.lesson18.model.Comment;

public interface CommentDao extends JpaRepository<Comment, Long> {

    void deleteByBook(Book book);

}
