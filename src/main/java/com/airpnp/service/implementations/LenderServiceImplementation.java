package com.airpnp.service.implementations;

import com.airpnp.data.LenderRepository;
import com.airpnp.domainmodel.Lender;
import com.airpnp.service.LenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LenderServiceImplementation implements LenderService {

    @Autowired
    private LenderRepository data;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private void encodePassword(Lender lender) {
        lender.setPassword(passwordEncoder.encode(lender.getPassword()));
    }

    @Override
    public void addLender(Lender lender) {
        encodePassword(lender);
        data.save(lender);
    }

    @Override
    public void deleteAll() {
        data.deleteAll();
    }
}
