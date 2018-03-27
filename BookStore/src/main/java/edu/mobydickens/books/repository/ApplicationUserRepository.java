package edu.mobydickens.books.repository;

/**
 * Created by 6586r on 11/18/2017.
 */

import edu.mobydickens.books.model.ApplicationUser;

public interface ApplicationUserRepository {

    ApplicationUser findUserByUserName(String username);

    ApplicationUser addUser(Long id, String username, String password, Boolean isBoolean);

}
