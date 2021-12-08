package com.airpnp.security;

import com.airpnp.domainmodel.Customer;
import com.airpnp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@Profile("production")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ROLE_CUSTOMER = "CUSTOMER";
    private static final String ROLE_LENDER = "LENDER";
    public static final String USER_ROLE_CUSTOMER = "ROLE_" + ROLE_CUSTOMER;
    public static final String USER_ROLE_LENDER = "ROLE_" + ROLE_LENDER;

    @Autowired
    private CustomerService customerService;

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("userCustomer")
                .password(encoder.encode("salasana1"))
                .roles(ROLE_CUSTOMER)
                .and()
                .withUser("userLender")
                .password(encoder.encode("salasana2"))
                .roles(ROLE_LENDER);

        List<Customer> allCustomers = customerService.getAll();
        for (Customer c : allCustomers) {
            System.out.println("Grant login access to user " + c);
            auth.inMemoryAuthentication().withUser(c.getUsername()).password(encoder.encode(c.getPassword())).roles(ROLE_CUSTOMER);
        }
    }

    /**
     *
     * @return username of logged in user. Or null if no user is logged in.
     */
    String getCurrentlyLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }

        return null;
    }

}
