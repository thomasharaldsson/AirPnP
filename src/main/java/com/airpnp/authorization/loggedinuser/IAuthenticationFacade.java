package com.airpnp.authorization.loggedinuser;

import com.airpnp.authorization.proxy.UserPrincipal;

public interface IAuthenticationFacade {
    UserPrincipal getAuthenticatedUser();
}
