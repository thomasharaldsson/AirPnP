package com.airpnp.data;

import com.airpnp.data.exception.CustomerNotFoundException;
import com.airpnp.data.exception.VehicleNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Vehicle;

import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer newCustomer);

    List<Customer> getAll();

    Customer getCustomerById(Integer id) throws CustomerNotFoundException;

    void updateCustomer(Customer customer) throws CustomerNotFoundException;

    void deleteCustomer(int id) throws CustomerNotFoundException;

    void deleteAll();
}
