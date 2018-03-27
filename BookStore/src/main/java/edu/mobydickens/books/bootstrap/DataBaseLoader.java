package edu.mobydickens.books.bootstrap;

/**
 * Created by 6586r on 11/18/2017.
 */
import edu.mobydickens.books.model.Book;
import edu.mobydickens.books.repository.ApplicationUserRepository;
import edu.mobydickens.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class DataBaseLoader implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        applicationUserRepository.addUser(1L,"admin","123456",Boolean.TRUE);

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        try {
            bookRepository.addBook(1,"Of Mice and Men","John Steinbeck",
                    df.parse("06/15/1937"), Book.Genre.art,13.75,978885870L);

            bookRepository.addBook(2, "The Old Man and the Sea", "Ernest Hemingway",
                    df.parse("09/01/1952"), Book.Genre.classics,9.99, 978858523L);

            bookRepository.addBook(3, "Tunnels", "Rodrick Gordon & Brian Williams",
                    df.parse("07/02/2007"), Book.Genre.mystery,5.99, 9545381258L);

            bookRepository.addBook(4, "Deeper", "Rodrick Gordon & Brian Williams",
                    df.parse("05/05/2008"), Book.Genre.mystery,7.99, 9545381266L);

            bookRepository.addBook(5, "Freefall", "Rodrick Gordon & Brian Williams",
                    df.parse("05/04/2009"), Book.Genre.mystery,6.99, 1906427054L);

            bookRepository.addBook(6, "Closer", "Rodrick Gordon & Brian Williams",
                    df.parse("05/03/2010"), Book.Genre.mystery,9.99, 9545201160L);


        } catch (ParseException e){
            e.printStackTrace();
        }
    }
}
