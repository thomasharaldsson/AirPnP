package com.airpnp.data;

import com.airpnp.data.exception.VehicleNotFoundException;
import com.airpnp.data.repository.VehicleRepository;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class VehicleDaoImpl implements VehicleDao {

    @Autowired
    VehicleRepository data;

    @PersistenceContext
    private EntityManager em;

    private final static String JPA_QUERY_GET_ALL_VEHICLE_FOR_CUSTOMER = "SELECT v FROM Vehicle v WHERE v.owner =: customer";

    @Override
    public void addVehicle(Vehicle newVehicle) {
        data.save(newVehicle);
    }

    @Override
    public List<Vehicle> getAll() {
        return data.findAll();
    }

    @Override
    public List<Vehicle> getAll(Customer customer) {
        return em.createQuery(JPA_QUERY_GET_ALL_VEHICLE_FOR_CUSTOMER).setParameter("customer", customer).getResultList();
    }

    @Override
    public Vehicle getVehicleById(Integer id) throws VehicleNotFoundException {
        if (data.findById(id).isPresent()) {
            return data.findById(id).get();
        } else {
            throw new VehicleNotFoundException("There is no vehicle with id = " + id + ".");
        }
    }

    @Override
    public void updateVehicle(Vehicle vehicle) throws VehicleNotFoundException {
        Integer vehicleId = vehicle.getId();
        if (!data.existsById(vehicleId)) {
            throw new VehicleNotFoundException("Unable to update space since vehicle with that id=" + vehicleId + " doesn't exist");
        }
        data.save(vehicle);
    }

    @Override
    public void deleteVehicle(int id) throws VehicleNotFoundException {
        data.delete(this.getVehicleById(Integer.valueOf(id)));
    }

    @Override
    public void deleteAll() {
        data.deleteAll();
    }
}
