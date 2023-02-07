package ru.otus.lesson18.service;

import ru.otus.lesson18.model.Author;
import ru.otus.lesson18.model.Book;
import ru.otus.lesson18.model.Comment;
import ru.otus.lesson18.model.Genre;

import java.util.List;
import java.util.Optional;

public interface LibraryService {

    List<Book> getAllBooks();
    void deleteBookById(Long id);
    Book saveBook(Book book);
    Book getBookById(Long id);
    List<Comment> getAllCommentsByBook(Book book);
    List<Author> getAllAuthore();
    List<Genre> getAllGenre();
    Optional<Author> getAuthorById(Long id);
    Optional<Genre> getGenreById(Long id);

}
