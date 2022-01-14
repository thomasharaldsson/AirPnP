package com.airpnp.authorization.proxy;

import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Admin;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static com.airpnp.authorization.SecurityConfig.USER_ROLE_CUSTOMER;
import static com.airpnp.authorization.SecurityConfig.USER_ROLE_ADMIN;


public class UserPrincipal implements UserDetails {

    private Customer customer;
    private Admin admin;

    public UserPrincipal(Customer customer) {
        this.customer = customer;
    }

    public UserPrincipal(Admin admin) {
        this.admin = admin;
    }

    /**
     * Get Entity from domain model representing currently logged in Customer user.
     *
     * @return Entity or currently logged in Customer user. Or null if an Customer user is not currently logged in.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Get Entity from domain model representing currently logged in Admin user.
     *
     * @return Entity or currently logged in Admin user. Or null if an Admin user is not currently logged in.
     */
    public Admin getAdmin() {
        return admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (customer != null) {
            authorities.add(new SimpleGrantedAuthority(USER_ROLE_CUSTOMER));
        }

        if (admin != null) {
            authorities.add(new SimpleGrantedAuthority(USER_ROLE_ADMIN));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        if (admin != null) {
            return admin.getPassword();
        }

        if (customer != null) {
            return customer.getPassword();
        }

        return null;
    }

    @Override
    public String getUsername() {
        if (admin != null) {
            return admin.getUsername();
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

    /**
     *  This method can be used from e.g. Controller classes to get currently logged in user.
     *  Please note that in order to get hold of the actual Entity (in package com.airpnp.domainmodel) representing this
     *  user you have to call either the getCustomer() or the getAdmin() in the UserPrincipal class.
     *
     *  Example #1:
     *  Customer currentCustomer = SecurityConfig.getCurrentlyLoggedInUserPrincipal().getCustomer();
     *
     *  Example #2:
     *  Admin currentAdmin = SecurityConfig.getCurrentlyLoggedInUserPrincipal().getAdmin();
     *
     * @return Security object representing the currently logged in user. Or null if no user is currently logged in.
     */
    public static UserPrincipal getCurrentlyLoggedInUserPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

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
