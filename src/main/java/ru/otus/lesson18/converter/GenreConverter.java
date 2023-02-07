package ru.otus.lesson18.converter;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.lesson18.dto.AuthorDto;
import ru.otus.lesson18.dto.GenreDto;
import ru.otus.lesson18.model.Author;
import ru.otus.lesson18.model.Genre;

@Component
@RequiredArgsConstructor
public class GenreConverter {

    public GenreDto entityToDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }

}
