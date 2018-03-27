package edu.mobydickens.books.service;

/**
 * Created by 6586r on 11/18/2017.
 */
import edu.mobydickens.books.model.ApplicationUser;
import edu.mobydickens.books.model.security.SecurityUser;
import edu.mobydickens.books.service.impl.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class MobyDickensBooksUserDetailsService implements UserDetailsService{

    @Autowired
    private ApplicationUserService applicationUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = applicationUserService.findUserByUserName(username);

        if (user == null)
        {
            throw new UsernameNotFoundException("Username Not found: " + username);
        }
        return new SecurityUser(user);
    }

}
