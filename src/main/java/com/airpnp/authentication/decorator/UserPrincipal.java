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

    /**
     * User in AirPnP application.
     */
    private final Customer customer;

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
     * Returns the password used to authenticate the user.
     *
     * @return password
     */
    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    /**
     * Returns the username used to authenticate the user. Cannot return null.
     *
     * @return the username (never null)
     */
    @Override
    public String getUsername() {
        return customer.getUsername();
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be authenticated.
     *
     * @return true if the user's account is valid (ie non-expired), false if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be authenticated.
     *
     * @return true if the user is not locked, false otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired credentials prevent authentication.
     *
     * @return true if the user's credentials are valid (ie non-expired), false if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be authenticated.
     *
     * @return true if the user is enabled, false otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     *  This convenience method can be used from e.g. Controller classes to get currently logged in user.
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
