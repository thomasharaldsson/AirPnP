package com.airpnp.service;

import com.airpnp.domainmodel.Lender;

public interface LenderService {
    void addLender(Lender lender);
    void deleteAll();
}
