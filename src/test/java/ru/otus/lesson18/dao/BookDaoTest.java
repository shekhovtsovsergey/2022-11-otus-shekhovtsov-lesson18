package ru.otus.lesson18.dao;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.otus.lesson18.model.Author;
import ru.otus.lesson18.model.Book;
import ru.otus.lesson18.model.Genre;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertAll;


@DataJpaTest
@DisplayName("Dao для работы с книгами должно")
class BookDaoTest {
    private static final int EXPECTED_BOOKS_COUNT = 5;
    private static final long BOOK_ID = 1L;
    private static final String BOOK_NAME = "Ned ad trappen, ud på gaden (Danish Edition)";
    private static final long EXPECTED_NEW_ID = 6;
    private static final long AUTHOR_ID = 1L;
    private static final long KING_ID = 2L;
    private static final long COMEDY_ID = 2L;

    @Autowired
    private TestEntityManager em;

    @Autowired
    private BookDao bookDao;
    @Autowired
    private CommentDao commentDao;

    @Test
    @DisplayName("возвращать ожидаемое количество книг в БД")
    void count() {
        long count = bookDao.count();
        assertThat(count).isEqualTo(EXPECTED_BOOKS_COUNT);
    }

    @Test
    @DisplayName("добавлять книгу в БД")
    void save() {
        Book expectedBook = new Book(null,"Spring in Action",em.find(Author.class, 1L), em.find(Genre.class, 1L),null);
        Book savedBook = bookDao.save(expectedBook);
        Optional<Book> actualBook = bookDao.findById(EXPECTED_NEW_ID);
        assertAll(() -> assertThat(savedBook.getId()).isEqualTo(EXPECTED_NEW_ID),
                () -> assertThat(actualBook).isPresent().get()
                        .isEqualTo(expectedBook));
    }

    @Test
    @DisplayName("возвращать ожидаемую книгу по ее id")
    void findById() {
        Optional<Book> actualBook = bookDao.findById(BOOK_ID);
        assertThat(actualBook).isPresent().get()
                .hasFieldOrPropertyWithValue("id", BOOK_ID)
                .hasFieldOrPropertyWithValue("name", BOOK_NAME);
    }

    @Test
    @DisplayName("возвращать все книги")
    void findAll() {
        List<Book> allBooks = bookDao.findAll();
        assertThat(allBooks).hasSize(EXPECTED_BOOKS_COUNT);
    }





    @Test
    @DisplayName("обновляет данные книги в БД")
    void saveMerge() {
        Book longWalkBook = em.find(Book.class, BOOK_ID);
        longWalkBook.setName("testName");
        longWalkBook.setAuthor(new Author(3L, null));
        longWalkBook.setGenre(new Genre(2L, null));
        bookDao.save(longWalkBook);
        Optional<Book> actualBook = bookDao.findById(1L);
        assertAll(() -> assertThat(actualBook).get().extracting(Book::getName).isEqualTo("testName"),
                () -> assertThat(actualBook).get().extracting(Book::getAuthor).extracting(Author::getId).isEqualTo(3L),
                () -> assertThat(actualBook).get().extracting(Book::getGenre).extracting(Genre::getId).isEqualTo(2L));
    }


}