package ru.otus.lesson18.dto;


import lombok.*;
import ru.otus.lesson18.model.Author;
import ru.otus.lesson18.model.Genre;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String name;
    private Author author;
    private Genre genre;
}
