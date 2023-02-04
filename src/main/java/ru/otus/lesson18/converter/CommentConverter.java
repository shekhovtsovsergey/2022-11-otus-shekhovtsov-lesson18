package ru.otus.lesson18.converter;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.lesson18.dto.CommentDto;
import ru.otus.lesson18.model.Comment;

@Component
@RequiredArgsConstructor
public class CommentConverter {

    public CommentDto entityToDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getBook(),comment.getAuthorName(), comment.getComment());
    }

}
