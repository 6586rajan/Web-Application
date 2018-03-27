package edu.mobydickens.books.model;

/**
 * Created by 6586r on 11/18/2017.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int bookId;
    private String title;
    private String author;
    private Date publishDate;
    private Genre genre;
    private Double bookPrice;
    private long iSBN;


    public enum Genre {
        drama,romance, mystery, comics, classics, scifi,
        fantasy, horror, ActionAndAdventure, art, satire
    }
}
