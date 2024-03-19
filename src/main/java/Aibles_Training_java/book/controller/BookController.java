package Aibles_Training_java.book.controller;

import Aibles_Training_java.book.dto.request.BookRequest;
import Aibles_Training_java.book.dto.response.BookResponse;
import Aibles_Training_java.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/books")
@Slf4j
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse create(@RequestBody BookRequest request){
        log.info(" === Start api create new book === ");
        log.info(" === Request Body : {} === ", request);
        BookResponse response = service.create(request);
        log.info(" === Finish api create new book, Book id : {} ===", response.getId());
        return response;
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse getById(@PathVariable ("id") String id ){
        log.info(" === Start api getById book === ");
        log.info(" === String id : {} ===", id);
        BookResponse response = service.getById(id);
        log.info(" === Finish api getById book, Book id : {} ==== ", response.getId());
        return response;
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse update(@RequestBody BookRequest request, @PathVariable ("id") String id){
        log.info(" === Start api update book === ");
        log.info(" === Request Body : {} , String id : {} === ", request, id);
        BookResponse response = service.update(request, id);
        log.info(" === Finish api update book, Book id : {} === ", response.getId());
        return response;
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable ("id") String id ){
        log.info(" === Start api deleteById book === ");
        log.info(" == String id : {} === ");
        log.info(" === Finish api deleteById book, Book Id : {} === ");
        service.deleteById(id);
    }
}
