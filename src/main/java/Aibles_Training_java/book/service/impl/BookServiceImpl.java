package Aibles_Training_java.book.service.impl;

import Aibles_Training_java.book.dto.request.BookRequest;
import Aibles_Training_java.book.dto.response.BookResponse;
import Aibles_Training_java.book.entity.BookEntity;
import Aibles_Training_java.book.repository.BookRepository;
import Aibles_Training_java.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static Aibles_Training_java.book.service.mapping.BookMapping.convertDtoToEntity;
import static Aibles_Training_java.book.service.mapping.BookMapping.convertEntityToBookResponse;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse create(BookRequest request) {
        log.info(" === Start api creat new book === ");
        log.info(" === Request Body : {} === ", request);
        BookEntity entity = convertDtoToEntity(request);
        entity = bookRepository.save(entity);
        BookResponse response = convertEntityToBookResponse(entity);
        log.info(" === Finish api creat new book, Book id : {} === ");
        return response;
    }

    @Override
    public BookResponse getById(String id) {
        log.info(" === Start api getById book === ");
        log.info(" === String id : {} === ", id);
        Optional<BookEntity> optionalBook = bookRepository.findById(id);
        if (!optionalBook.isPresent()){
            throw new RuntimeException();
        }
        BookEntity entity = optionalBook.get();
        entity = bookRepository.save(entity);
        BookResponse response = convertEntityToBookResponse(entity);
        log.info(" === Finish api getById book, Book Id : {} === ", response.getId());
        return response;
    }

    @Override
    public BookResponse update(BookRequest request, String id) {
        log.info(" === Start api update book === ");
        log.info(" === Request Body : {} , String id : {} === ", request, id);
        Optional<BookEntity> optionalBook = bookRepository.findById(id);
        if (! optionalBook.isPresent()){
            throw new RuntimeException();
        }
        BookEntity entity = optionalBook.get();
        entity.setTitle(request.getTitle());
        entity.setCategory(request.getCategory());
        entity.setPrice(request.getPrice());
        entity.setPrice(request.getPrice());
        entity = bookRepository.save(entity);
        BookResponse response = convertEntityToBookResponse(entity);
        log.info(" === Finish api update book , Book Id : {} === ", response.getId());
        return response;
    }

    @Override
    public void deleteById(String id) {
        log.info(" === Start api deleteById === ");
        log.info(" === String id : {} === ", id);
        Optional<BookEntity> optionalBook = bookRepository.findById(id);
        if (! optionalBook.isPresent()){
            throw new RuntimeException();
        }
        log.info(" === Finish api deleteById, Book id : {} === ");
        bookRepository.deleteById(id);
    }
}
