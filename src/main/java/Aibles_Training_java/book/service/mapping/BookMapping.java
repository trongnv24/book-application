package Aibles_Training_java.book.service.mapping;

import Aibles_Training_java.book.dto.request.BookRequest;
import Aibles_Training_java.book.dto.response.BookResponse;
import Aibles_Training_java.book.entity.BookEntity;

public class BookMapping {
    public static BookEntity convertDtoToEntity(BookRequest dto){
        BookEntity entity = new BookEntity();
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setPrice(dto.getPrice());
        entity.setCategory(dto.getCategory());
        return entity;
    }
    public static BookResponse convertEntityToBookResponse(BookEntity entity){
        BookResponse dto = new BookResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setAuthor(entity.getAuthor());
        dto.setPrice(entity.getPrice());
        dto.setCategory(entity.getCategory());
        return dto;
    }
}
