package com.airpnp.authentication.loggedinuser;

import com.airpnp.authentication.proxy.UserPrincipal;

public interface IAuthenticationFacade {
    UserPrincipal getAuthenticatedUser();
}
