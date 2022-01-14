package com.airpnp.authorization;

import com.airpnp.authorization.proxy.UserPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@Profile("production")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ROLE_CUSTOMER = "CUSTOMER";
    private static final String ROLE_ADMIN = "ADMIN";
    public static final String USER_ROLE_CUSTOMER = "ROLE_" + ROLE_CUSTOMER;
    public static final String USER_ROLE_ADMIN = "ROLE_" + ROLE_ADMIN;

    @Resource
    private UserDetailsService userDetailsService;

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {

        security
                .authorizeRequests().antMatchers("/", "/css/**").permitAll()
                .antMatchers("/parkingspace/showall").permitAll()
                .antMatchers("/customer/*").permitAll()
                .antMatchers("/vehicle/*").hasRole("CUSTOMER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();

        // Select page that will be opened after user has been successfully logged out.
        security.logout().logoutSuccessUrl("/");
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
