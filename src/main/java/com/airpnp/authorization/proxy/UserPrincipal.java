package com.airpnp.authorization.proxy;

import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Lender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static com.airpnp.authorization.SecurityConfig.USER_ROLE_CUSTOMER;
import static com.airpnp.authorization.SecurityConfig.USER_ROLE_LENDER;


public class UserPrincipal implements UserDetails {

    private Customer customer;
    private Lender lender;

    public UserPrincipal(Customer customer) {
        this.customer = customer;
    }

    public UserPrincipal(Lender lender) {
        this.lender = lender;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Lender getLender() {
        return lender;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (customer != null) {
            authorities.add(new SimpleGrantedAuthority(USER_ROLE_CUSTOMER));
        }

        if (lender != null) {
            authorities.add(new SimpleGrantedAuthority(USER_ROLE_LENDER));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        if (lender != null) {
            return lender.getPassword();
        }

        if (customer != null) {
            return customer.getPassword();
        }

        return null;
    }

    @Override
    public String getUsername() {
        if (lender != null) {
            return lender.getUsername();
        }

        if (customer != null) {
            return customer.getUsername();
        }

        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}