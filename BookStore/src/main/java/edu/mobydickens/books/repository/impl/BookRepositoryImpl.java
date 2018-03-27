package edu.mobydickens.books.repository.impl;

/**
 * Created by 6586r on 11/18/2017.
 */
import com.google.common.collect.MoreCollectors;
import edu.mobydickens.books.model.Book;
import edu.mobydickens.books.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class BookRepositoryImpl implements BookRepository{

    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> findAllBooks() {return books;}

    @Override
    public Book findBookById(int bookId){

        return books.stream()
                .filter(book -> book.getBookId() == (bookId))
                .collect(MoreCollectors.onlyElement());
    }

    @Override
    public Book addBook(int bookId, String title, String author, Date publishDate, Book.Genre genre, Double bookPrice, Long iSBN) {
        Book toAdd = new Book(bookId, title, author, publishDate, genre, bookPrice, iSBN);
        books.add(toAdd);
        return toAdd;
    }

    @Override
    public List<Book> findAllBooksFiltered(String filterName) {

        return  books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(filterName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Book editBook(int bookId, String title, String author, Date publishDate, Book.Genre genre, String bookPrice, Long iSBN)
    {
        Book current = null;

        for (Book book: books)
        {
            if (book.getBookId() == bookId)
            {
                current = book;
            }
        }

        if (current != null)
        {
            current.setTitle(title);
            current.setAuthor(author);
            current.setPublishDate(publishDate);
            current.setGenre(genre);
            current.setBookPrice(Double.valueOf(bookPrice));
            current.setISBN(iSBN);
        }

        return current;
    }

    @Override
    public void deleteBook(int bookId) {
        Book current = null;

        for (Book book : books) {
            if (book.getBookId() == (bookId)) {
                current = book;
            }
        }

        if (current != null) {
            books.remove(current);
        }
    }

}
