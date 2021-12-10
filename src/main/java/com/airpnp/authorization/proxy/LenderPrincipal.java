package com.airpnp.authorization.proxy;

import com.airpnp.domainmodel.Lender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.airpnp.authorization.SecurityConfig.*;

public class LenderPrincipal implements UserDetails {

    private Lender lender;

    public LenderPrincipal(Lender lender) {
        this.lender = lender;
    }

    public LenderPrincipal() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(USER_ROLE_LENDER));
        return authorities;
    }

    @Override
    public String getPassword() {
        return lender.getPassword();
    }

    @Override
    public String getUsername() {
        return lender.getUsername();
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