package com.airpnp.security;

import com.airpnp.domainmodel.Customer;
import com.airpnp.service.CustomerPrincipal;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class LoginEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {

        // if you just need the login
        String login = event.getAuthentication().getName();
        System.out.println(login + " has just logged in");

        // if you need to access full user (ie only roles are interesting -- the rest is already verified as login is successful)
        CustomerPrincipal userPrincipal = (CustomerPrincipal) event.getAuthentication().getPrincipal();
        System.out.println(userPrincipal.getUsername() + " has just logged in");

    }
}
