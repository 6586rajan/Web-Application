package edu.mobydickens.books.service.impl;

/**
 * Created by 6586r on 11/18/2017.
 */

import edu.mobydickens.books.model.ApplicationUser;

public interface ApplicationUserService {

    ApplicationUser findUserByUserName(String username);
}
