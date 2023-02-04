package ru.otus.lesson18.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.lesson18.converter.BookConverter;
import ru.otus.lesson18.converter.CommentConverter;
import ru.otus.lesson18.model.Book;
import ru.otus.lesson18.service.LibraryService;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final LibraryService libraryService;
    private final BookConverter bookConverter;
    private final CommentConverter commentConverter;

    @GetMapping("/all")
    public String getBookList(Model model) {
        model.addAttribute("books", libraryService.getAllBooks().stream().map(bookConverter::entityToDto).collect(Collectors.toList()));
        return "book-list";
    }

    @GetMapping
    public String showForm(Model model, @RequestParam(name = "id", required = false) Long id) {
        Book book;
        if (id != null) {
            book = libraryService.getBookById(id);
        } else {
            book = new Book();
        }
        model.addAttribute("book", book);
        return "book-form";
    }

    @GetMapping("/{bookId}")
    public String info(Model model, @PathVariable(name = "bookId") Long id) {
        Book book;
        if (id != null) {
            book = libraryService.getBookById(id);
        } else {
            return "redirect:/book/all";
        }
        model.addAttribute("book", book);
        return "book-info";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        libraryService.deleteBookById(id);
        return "redirect:/book/all";
    }

    @GetMapping("comment/{bookId}")
    public String getCommentList(Model model, @PathVariable(name = "bookId") Long id) {
        model.addAttribute("comments", libraryService.getAllCommentsByBook(new Book(id, null, null, null,null)).stream().map(commentConverter::entityToDto).collect(Collectors.toList()));
        return "comment-list";
    }

    @PostMapping
    public String saveBook(Book book) {
        libraryService.saveBook(book);
        return "redirect:/book/all";
    }

}
