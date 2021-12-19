package com.airpnp.service;

import com.airpnp.data.exception.UsernameAlreadyInUseException;
import com.airpnp.domainmodel.Lender;

public interface LenderService {
    void addLender(Lender lender) throws UsernameAlreadyInUseException;
    void deleteAll();
    Lender findByUsername(String username);
}
