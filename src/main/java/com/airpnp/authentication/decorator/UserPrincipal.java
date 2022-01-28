package com.airpnp.authentication.decorator;

import com.airpnp.domainmodel.Customer;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static com.airpnp.authentication.SecurityConfig.USER_ROLE_CUSTOMER;
import static com.airpnp.authentication.SecurityConfig.USER_ROLE_ADMIN;


/**
 * Datastructure that Spring uses access information regarding currently logged in user.
 */
public class UserPrincipal implements UserDetails {

    private Customer customer;

    public UserPrincipal(Customer customer) {
        this.customer = customer;
    }

    /**
     * Get Entity from domain model representing currently logged in Customer user.
     *
     * @return Entity or currently logged in Customer user. Or null if a Customer user is not currently logged in.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Supply Spring Security library with an object that represents user roles for currently logged in user.
     *
     * @return Spring Security authorities for currently logged in user.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (customer.isAdmin()) {
            authorities.add(new SimpleGrantedAuthority(USER_ROLE_ADMIN));

        } else {
            authorities.add(new SimpleGrantedAuthority(USER_ROLE_CUSTOMER));
        }

        return authorities;
    }

    /**
     * Get password.
     *
     * @return Password of current user.
     */

    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    /**
     * Get username.
     *
     * @return Username of current user.
     */
    @Override
    public String getUsername() {
        return customer.getUsername();
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

    /**
     *  This method can be used from e.g. Controller classes to get currently logged in user.
     *  Please note that in order to get hold of the actual Entity (in package com.airpnp.domainmodel) representing this
     *  user you have to call the getCustomer() method in the UserPrincipal class.
     *
     *  Example #1:
     *  Customer currentCustomer = UserPrincipal.getCurrentlyLoggedInUserPrincipal().getCustomer();
     *
     * @return Security object representing the currently logged in user. Or null if no user is currently logged in.
     */
    public static UserPrincipal getCurrentlyLoggedInUserPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // user is not logged in yet
        if (authentication == null) {
            return null;
        }

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

            return userPrincipal;
        }

        return null;
    }
}
