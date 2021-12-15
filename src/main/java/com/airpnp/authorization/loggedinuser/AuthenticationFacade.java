package com.airpnp.authorization.loggedinuser;

import com.airpnp.authorization.proxy.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {
    @Override
    public UserPrincipal getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication!=null) {
            return (UserPrincipal) authentication.getPrincipal();
        }

        return null;
    }
}
