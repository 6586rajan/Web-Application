package edu.mobydickens.books.repository;

/**
 * Created by 6586r on 11/18/2017.
 */
import edu.mobydickens.books.model.Book;

import java.util.Date;
import java.util.List;

public interface BookRepository {

    List<Book> findAllBooks();

    Book findBookById(int bookId);

    List<Book> findAllBooksFiltered(String filterName);

    Book addBook(int bookId, String title, String author, Date publishDate, Book.Genre genre, Double bookPrice, Long iSBN);

    Book editBook(int bookId, String title, String author, Date publishDate, Book.Genre genre, String bookPrice, Long iSBN);

    void deleteBook(int bookId);

}
