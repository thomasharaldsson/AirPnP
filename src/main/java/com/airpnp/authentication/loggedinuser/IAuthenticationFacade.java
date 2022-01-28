package com.airpnp.authentication.loggedinuser;

import com.airpnp.authentication.decorator.UserPrincipal;

public interface IAuthenticationFacade {
    UserPrincipal getAuthenticatedUser();
}
