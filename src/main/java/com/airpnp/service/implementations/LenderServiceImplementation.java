package com.airpnp.service.implementations;

import com.airpnp.data.LenderRepository;
import com.airpnp.data.exception.UsernameAlreadyInUseException;
import com.airpnp.domainmodel.Lender;
import com.airpnp.service.CustomerService;
import com.airpnp.service.LenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LenderServiceImplementation implements LenderService {

    @Autowired
    private LenderRepository data;

    @Autowired
    CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private void encodePassword(Lender lender) {
        lender.setPassword(passwordEncoder.encode(lender.getPassword()));
    }

    @Override
    public void addLender(Lender lender) throws UsernameAlreadyInUseException {
        // Check if there already exists customer or lender with this username
        if (customerService.findByUsername( lender.getUsername() ) != null || this.findByUsername( lender.getUsername() ) != null) {
            throw new UsernameAlreadyInUseException("Username " + lender.getUsername() + " is already in use. Please choose another.");
        }
        encodePassword(lender);
        data.save(lender);
    }

    @Override
    public void deleteAll() {
        data.deleteAll();
    }

    @Override
    public Lender findByUsername(String username) {
        return data.findByUsername(username);
    }
}
