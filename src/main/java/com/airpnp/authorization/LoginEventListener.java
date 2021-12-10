package com.airpnp.authorization;

import com.airpnp.authorization.proxy.CustomerPrincipal;
import com.airpnp.authorization.proxy.LenderPrincipal;
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
        if (userDetails.getClass() == CustomerPrincipal.class) {
            // Customer has logged in
            CustomerPrincipal userPrincipal = (CustomerPrincipal) userDetails;
            System.out.println("Customer " + userPrincipal.getUsername() + " has just logged in");
        }
        if (userDetails.getClass() == LenderPrincipal.class) {
            // Lender has logged in.
            LenderPrincipal userPrincipal = (LenderPrincipal) userDetails;
            System.out.println("Lender " + userPrincipal.getUsername() + " has just logged in");
        }
    }
}
