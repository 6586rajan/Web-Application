package edu.mobydickens.books.service.impl;

import edu.mobydickens.books.model.Book;
import edu.mobydickens.books.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    public void test_find_all_books() throws Exception {

        List<Book> bookList = bookService.findAllBooks();
        assertNotNull(bookList);
    }

    @Test
    public void findBookById() throws Exception {

        Book book = bookService.findBookById(1123);
        assertEquals("Of Mice and Men", book.getTitle());
    }


}
