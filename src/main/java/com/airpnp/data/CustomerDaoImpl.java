package com.airpnp.data;

import com.airpnp.data.exception.CustomerNotFoundException;
import com.airpnp.data.exception.VehicleNotFoundException;
import com.airpnp.data.repository.CustomerRepository;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDaoImpl implements CustomerDao {


    @Override
    public void addCustomer(Customer newCustomer) {
        
    }

    @Override
    public List<Vehicle> getAll() {
        return null;
    }

    @Override
    public List<Vehicle> getAll(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomerById(Integer id) throws CustomerNotFoundException {
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) throws CustomerNotFoundException {

    }

    @Override
    public void deleteCustomer(int id) throws CustomerNotFoundException {

    }

    @Override
    public void deleteAll() {

    }
}
