package ru.otus.lesson18.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.lesson18.dao.BookDao;
import ru.otus.lesson18.dao.CommentDao;
import ru.otus.lesson18.model.Book;
import ru.otus.lesson18.model.Comment;
import java.util.List;


@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final BookDao bookDao;
    private final CommentDao commentDao;

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

}
