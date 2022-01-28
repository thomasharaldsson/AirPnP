package com.airpnp.authentication;

import com.airpnp.authentication.decorator.UserPrincipal;
import com.airpnp.data.repository.CustomerRepository;
import com.airpnp.domainmodel.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * This method is called by Spring Security once user has filled and submitted in the automatic login form provided by Spring Security.
     * @param username of user who is attempting to login to (web)application.
     * @return Object representing the user that is attempting to login.
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        Customer customer = null;

        // First look for users among customers. If user isn't there look among lenders.
        customer = customerRepository.findByUsername(username);
        if (customer != null) {
            return new UserPrincipal(customer);
        }

        // User was not found among customers or lenders.
        throw new UsernameNotFoundException(username);
    }
}