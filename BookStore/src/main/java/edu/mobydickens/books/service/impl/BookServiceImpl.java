package edu.mobydickens.books.service.impl;

/**
 * Created by 6586r on 11/18/2017.
 */
import edu.mobydickens.books.model.Book;
import edu.mobydickens.books.repository.BookRepository;
import edu.mobydickens.books.repository.impl.BookRepositoryImpl;
import edu.mobydickens.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks(){ return bookRepository.findAllBooks();}

    @Override
    public Book findBookById(int bookId){ return bookRepository.findBookById(bookId);}

    @Override
    public List<Book> findAllBooksFiltered(String filterName){
        return bookRepository.findAllBooksFiltered(filterName);
    }

    @Override
    public Book addBook(String title, String author, String publishDate, String genre, String bookPrice, String iSBN){

        Book tempB = null;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        try {
            tempB = bookRepository.addBook(findAllBooks().size()+ 1, title, author,
                    df.parse(publishDate), Book.Genre.valueOf(genre), Double.valueOf(bookPrice), Long.parseLong(iSBN));
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return tempB;
    }

    @Override
    public Book editBook(String bookId,String title, String author, String publishDate, String genre, String bookPrice, String iSBN)
    {
        Book tempB = null;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        try {
            tempB = bookRepository.editBook(Integer.parseInt(bookId), title, author,
                    df.parse(publishDate), Book.Genre.valueOf(genre), bookPrice, Long.parseLong(iSBN));
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return tempB;
    }

    @Override
    public void deleteBook(int bookId){bookRepository.deleteBook(bookId);}
}
