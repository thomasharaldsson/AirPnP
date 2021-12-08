package com.airpnp.security;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {

        // if you just need the login
        String login = event.getAuthentication().getName();
        System.out.println(login + " has just logged in");

        // if you need to access full user (ie only roles are interesting -- the rest is already verified as login is successful)
        User user = (User) event.getAuthentication().getPrincipal();
        System.out.println(user.getUsername() + " has just logged in");

    }
}
