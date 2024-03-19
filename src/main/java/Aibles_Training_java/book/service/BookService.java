package Aibles_Training_java.book.service;

import Aibles_Training_java.book.dto.request.BookRequest;
import Aibles_Training_java.book.dto.response.BookResponse;

public interface BookService {

    BookResponse create(BookRequest request);
    BookResponse getById(String id);

    BookResponse update(BookRequest request, String id);
    void deleteById(String id);
}
