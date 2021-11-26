package com.airpnp.service;

import com.airpnp.domainmodel.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    void update(Customer customer);

    Customer getCustomer(int id);

    List<Customer> getAll();
}
