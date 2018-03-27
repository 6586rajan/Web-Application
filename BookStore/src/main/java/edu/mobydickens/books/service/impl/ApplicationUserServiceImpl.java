package edu.mobydickens.books.service.impl;

/**
 * Created by 6586r on 11/18/2017.
 */
import edu.mobydickens.books.model.ApplicationUser;
import edu.mobydickens.books.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService{

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public ApplicationUser findUserByUserName(String username) {
        return applicationUserRepository.findUserByUserName(username);
    }
}
