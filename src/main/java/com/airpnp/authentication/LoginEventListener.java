package com.airpnp.authentication;

import com.airpnp.authentication.proxy.UserPrincipal;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class LoginEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {

        /*
        // if you just need the login
        String login = event.getAuthentication().getName();
        System.out.println(login + " has just logged in");
         */

        UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
        if (userDetails.getClass() == UserPrincipal.class) {
            UserPrincipal user = (UserPrincipal) userDetails;

            if (user.getCustomer() != null) {
                System.out.println("Customer " + user.getUsername() + " has just logged in");
            }

        }
    }
}
