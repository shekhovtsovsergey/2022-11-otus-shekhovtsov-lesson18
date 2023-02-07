package ru.otus.lesson18.dao;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.otus.lesson18.model.Book;
import ru.otus.lesson18.model.Comment;
import static org.junit.jupiter.api.Assertions.assertAll;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@DisplayName("Dao для работы с комментариями должно")
class CommentDaoTest {
    private static final long EXPECTED_NEW_ID = 9;
    private static final long PETR1_LONG_WALK_COMMENT_ID = 4;
    private static final long LONG_WALK_BOOK_ID = 2;
    private static final long KRISTINA_BOOK_ID = 1;
    private static final int EXPECTED_COMMENTS_FOR_LONG_WALK_COUNT = 5;

    @Autowired
    private TestEntityManager em;

    @Autowired
    private CommentDao commentDao;


    @Test
    @DisplayName("удаляет комментарий по id")
    void deleteById() {
        commentDao.deleteById(PETR1_LONG_WALK_COMMENT_ID);
        List<Comment> allComments = commentDao.findAll();
        assertAll(() -> assertThat(allComments).hasSize(EXPECTED_COMMENTS_FOR_LONG_WALK_COUNT - 1),
                () -> assertThat(allComments.stream()).noneMatch(c -> c.getId().equals(PETR1_LONG_WALK_COMMENT_ID)));
    }
}