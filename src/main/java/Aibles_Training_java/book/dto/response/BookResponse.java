package Aibles_Training_java.book.dto.response;

import Aibles_Training_java.book.dto.request.BookRequest;

public class BookResponse extends BookRequest {
    private String id;

    public BookResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BookResponse{" +
                "id='" + id + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", price=" + getPrice() +
                ", category='" + getCategory() + '\'' +
                '}';
    }
}
