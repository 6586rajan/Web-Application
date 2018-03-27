package edu.mobydickens.books.model;

/**
 * Created by 6586r on 11/18/2017.
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUser {
    protected Long id;
    protected String username;
    protected String password;
    protected Boolean isAdmin;
}
