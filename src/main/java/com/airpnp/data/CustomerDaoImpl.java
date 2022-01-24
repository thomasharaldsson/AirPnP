package com.airpnp.data;

import com.airpnp.data.exception.CustomerNotFoundException;
import com.airpnp.data.exception.VehicleNotFoundException;
import com.airpnp.data.repository.CustomerRepository;
import com.airpnp.data.repository.VehicleRepository;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    CustomerRepository data;

    @PersistenceContext
    private EntityManager em;


    @Override
    public void addCustomer(Customer newCustomer) {
        data.save(newCustomer);
    }

    @Override
    public List<Customer> getAll() {
        return data.findAll();
    }

    @Override
    public Customer getCustomerById(Integer id) throws CustomerNotFoundException {

        return data.findById(id).get();
    }

    @Override
    public void updateCustomer(Customer customer) throws CustomerNotFoundException {
        data.save(customer);
    }

    @Override
    public void deleteCustomer(int id) throws CustomerNotFoundException {
        data.delete(this.getCustomerById(id));
    }

    @Override
    public void deleteAll() {
        data.deleteAll();
    }
}
