package ru.otus.lesson18.service;

import ru.otus.lesson18.model.Book;
import ru.otus.lesson18.model.Comment;
import java.util.List;

public interface LibraryService {

    List<Book> getAllBooks();
    void deleteBookById(Long id);
    Book saveBook(Book book);
    Book getBookById(Long id);
    List<Comment> getAllCommentsByBook(Book book);

}
