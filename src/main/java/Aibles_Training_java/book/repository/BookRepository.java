package Aibles_Training_java.book.repository;

import Aibles_Training_java.book.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
}
