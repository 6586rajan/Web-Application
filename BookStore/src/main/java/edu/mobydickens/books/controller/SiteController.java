package edu.mobydickens.books.controller;

/**
 * Created by 6586r on 11/18/2017.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {


    @GetMapping(value = "/search")
    public String search() {return "search";}

    @GetMapping(value = "/contact-us")
    public String contactUs() {return "contactus";}

}
