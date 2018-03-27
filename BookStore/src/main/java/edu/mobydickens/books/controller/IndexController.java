package edu.mobydickens.books.controller;

/**
 * Created by 6586r on 11/18/2017.
 */
import edu.mobydickens.books.model.Book;
import edu.mobydickens.books.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/")
    public String indexPage(Model model) {
        List<Book> bookList = null;
        model.addAttribute("bookList", bookList);
        return "index";
    }

    @PostMapping(value = "/")
    public String filteredIndexPage(@RequestParam String filterName, Model model) {
        List<Book> bookList = bookService.findAllBooksFiltered(filterName);
        model.addAttribute("bookList", bookList);
        return "index";
    }

    @GetMapping(value = "/admin/books/view")
    public String viewPage(Model model) {
        List<Book> bookList = bookService.findAllBooks();
        model.addAttribute("bookList", bookList);
        return "view";
    }

    @PostMapping(value = "/admin/books/view")
    public String filteredViewPage(@RequestParam String filterName, Model model) {
        List<Book> bookList = bookService.findAllBooksFiltered(filterName);
        model.addAttribute("bookList", bookList);
        return "view";
    }

    @GetMapping(value = "/admin/books/add")
    public String addBookPage() {return "addbook";}

    @PostMapping(value = "/admin/books/add")
    public String addBookForm(@RequestParam String title, @RequestParam String author, @RequestParam String publishDate,
                              @RequestParam String genre, @RequestParam String bookPrice, @RequestParam String iSBN){
        bookService.addBook(title,author,publishDate,genre,bookPrice,iSBN);
        return "redirect:/admin/books/view";
    }

    @GetMapping(value = "/admin/books/edit/{bookId}")
    public String editBookPage(@PathVariable(value = "bookId") int bookId, Model model)
    {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        if (bookId <= 0)
        {
            throw new IllegalStateException("Book Id is required!");
        }

        Book book = bookService.findBookById(bookId);

        if (book != null)
        {
            model.addAttribute("title",book.getTitle());
            model.addAttribute("author",book.getAuthor());
            model.addAttribute("publishDate",df.format(book.getPublishDate()));
            model.addAttribute("genre",book.getGenre());
            model.addAttribute("bookPrice",book.getBookPrice());
            model.addAttribute("iSBN",book.getISBN());
        }
        return "editbook";
    }


    @PostMapping(value = "/admin/books/edit")
    public String editBookForm(@RequestParam String bookId,@RequestParam String title, @RequestParam String author, @RequestParam String publishDate,
                               @RequestParam String genre, @RequestParam String bookPrice, @RequestParam String iSBN)
    {
        if (Integer.parseInt(bookId) <= 0)
        {
            throw new IllegalStateException("Book Id is required!");
        }

        Book book = bookService.editBook(bookId,title,author,publishDate,genre,bookPrice,iSBN);
        log.debug(book.getBookId() + " has been successfully edited");
        return "redirect:/admin/books/view";
    }

    @GetMapping(value = "/admin/books/delete/{bookId}")
    public String deleteBookPage(@PathVariable(value = "bookId") int bookId) {

        if (bookId <= 0){
            throw new IllegalStateException("Book ID is required!");
        }



        bookService.deleteBook(bookId);

        return "redirect:/admin/books/view";
    }




}
