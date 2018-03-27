package edu.mobydickens.books.config;

/**
 * Created by 6586r on 11/18/2017.
 */
import edu.mobydickens.books.service.MobyDickensBooksUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MobyDickensBooksUserDetailsService mobyDickensBooksUserDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/css/**", "/images/**", "/img/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()

                // public pages
                .antMatchers("/", "/contact-us", "/search").permitAll()

                // authenticated pages
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("userPass")
                .defaultSuccessUrl("/",true)
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/logout-success")
                .permitAll();

        // make this all work
        http.headers().frameOptions().disable();
        http.csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder aMB) throws Exception {

        aMB.userDetailsService(mobyDickensBooksUserDetailsService)
                .passwordEncoder(new PlaintextPasswordEncoder());
    }

}
