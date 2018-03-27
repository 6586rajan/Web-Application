package edu.mobydickens.books.service;

/**
 * Created by 6586r on 11/18/2017.
 */

import edu.mobydickens.books.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();

    Book findBookById(int bookId);

    List<Book> findAllBooksFiltered(String filterName);

    Book addBook(String title, String author, String publishDate, String genre, String bookPrice, String iSBN);

    void deleteBook(int bookId);

    Book editBook(String bookId,String title, String author, String publishDate, String genre, String bookPrice, String iSBN);
}
