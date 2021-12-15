package com.airpnp.authorization;

import com.airpnp.authorization.proxy.UserPrincipal;
import com.airpnp.data.CustomerRepository;
import com.airpnp.data.LenderRepository;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Lender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LenderRepository lenderRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Customer customer = null;
        Lender lender = null;

        // First look for users among customers. If user isn't there look among lenders.
        customer = customerRepository.findByUsername(username);
        if (customer != null) {
            return new UserPrincipal(customer);
        }

        lender = lenderRepository.findByUsername(username);
        if (lender != null) {
            return new UserPrincipal(lender);
        }

        // User was not found among customers or lenders.
        throw new UsernameNotFoundException(username);
    }
}