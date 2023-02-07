package ru.otus.lesson18.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.lesson18.dao.AuthorDao;
import ru.otus.lesson18.dao.BookDao;
import ru.otus.lesson18.dao.CommentDao;
import ru.otus.lesson18.dao.GenreDao;
import ru.otus.lesson18.model.Author;
import ru.otus.lesson18.model.Book;
import ru.otus.lesson18.model.Comment;
import ru.otus.lesson18.model.Genre;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final BookDao bookDao;
    private final CommentDao commentDao;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    @Transactional
    public void deleteBookById(Long id) {
        commentDao.deleteByBook(new Book(id,null,null,null,null));
        bookDao.deleteById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookDao.findBookById(id);
    }

    @Override
    public List<Comment> getAllCommentsByBook(Book book) {
      return  bookDao.findBookById(book.getId()).getComments();
    }

    @Override
    public List<Author> getAllAuthore() {
        return authorDao.findAll();
    }

    public List<Genre> getAllGenre() {
        return genreDao.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        return authorDao.findById(id);
    }

    @Override
    public Optional<Genre> getGenreById(Long id) {
        return genreDao.findById(id);
    }

}
