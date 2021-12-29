package com.airpnp.service;

import com.airpnp.data.exception.UsernameAlreadyInUseException;
import com.airpnp.domainmodel.Admin;

public interface AdminService {
    void addAdmin(Admin lender) throws UsernameAlreadyInUseException;
    void deleteAll();
    Admin findByUsername(String username);
}
