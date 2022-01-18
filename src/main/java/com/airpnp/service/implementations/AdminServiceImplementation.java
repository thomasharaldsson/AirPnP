package com.airpnp.service.implementations;

import com.airpnp.data.repository.AdminRepository;
import com.airpnp.data.exception.UsernameAlreadyInUseException;
import com.airpnp.domainmodel.Admin;
import com.airpnp.service.CustomerService;
import com.airpnp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImplementation implements AdminService {

    @Autowired
    private AdminRepository data;

    @Autowired
    CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private void encodePassword(Admin lender) {
        lender.setPassword(passwordEncoder.encode(lender.getPassword()));
    }

    @Override
    public void addAdmin(Admin admin) throws UsernameAlreadyInUseException {
        // Check if there already exists customer or admin with this username
        if (customerService.findByUsername( admin.getUsername() ) != null || this.findByUsername( admin.getUsername() ) != null) {
            throw new UsernameAlreadyInUseException("Username " + admin.getUsername() + " is already in use. Please choose another.");
        }
        encodePassword(admin);
        data.save(admin);
    }

    @Override
    public void deleteAll() {
        data.deleteAll();
    }

    @Override
    public Admin findByUsername(String username) {
        return data.findByUsername(username);
    }
}
