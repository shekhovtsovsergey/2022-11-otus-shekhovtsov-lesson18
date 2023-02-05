package ru.otus.lesson18.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.otus.lesson18.dao.AuthorDao;
import ru.otus.lesson18.dao.BookDao;
import ru.otus.lesson18.dao.CommentDao;
import ru.otus.lesson18.dao.GenreDao;
import ru.otus.lesson18.model.Book;
import ru.otus.lesson18.model.Comment;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;



@SpringBootTest
@DisplayName("Сервис библиотеки должен")
class LibraryServiceImplTest {

    @Configuration
    @Import(LibraryServiceImpl.class)
    static class NestedConfiguration {
    }

    @MockBean
    private AuthorDao authorDao;
    @MockBean
    private GenreDao genreDao;
    @MockBean
    private Book book;
    @MockBean
    private BookDao bookDao;
    @MockBean
    private CommentDao commentDao;
    @Autowired
    private LibraryService libraryService;


    @Test
    @DisplayName("корректно вызывать bookDao.save")
    void saveBook() {
        Book book = new Book(null, null, null, null,null);
        libraryService.saveBook(book);
        verify(bookDao).save(book);
    }

    @Test
    @DisplayName("корректно вызывать bookDao.findBookById")
    void getBookById() {
        libraryService.getBookById(1L);
        verify(bookDao).findBookById(1L);
    }

    @Test
    @DisplayName("корректно вызывать bookDao.findAll")
    void getAllBooks() {
        libraryService.getAllBooks();
        verify(bookDao).findAll();
    }

    @Test
    @DisplayName("корректно вызывать bookDao.deleteById")
    void deleteBookById() {
        libraryService.deleteBookById(1L);
        verify(bookDao).deleteById(1L);
    }

    @Test
    @DisplayName("корректно вызывать bookDao.findBookById")
    void getAllCommentsByBook() {
        Comment comment = new Comment(1L,book,null,"скукота");
        List <Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        Book book = new Book(1L, null, null, null,commentList);

        libraryService.getAllCommentsByBook(book);
        verify(bookDao).findBookById(1L).getComments();
    }

}