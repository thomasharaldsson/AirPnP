package com.airpnp.service.implementations;

import com.airpnp.data.ParkingSpaceDao;
import com.airpnp.data.repository.ParkingSpaceRepository;
import com.airpnp.data.repository.RentalTicketRepository;
import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.NoSuchElementException;

@Primary
@Service("parkingSpaceService")
public class ParkingSpaceProductionImpl implements ParkingSpaceService {

    @Autowired
    private ParkingSpaceDao data;

    @Override
    public ParkingSpace getParkingSpaceById(Integer id) throws ParkingSpaceNotFoundException {
        return data.getParkingSpaceById(id);
    }

    @Override
    public List<ParkingSpace> getAllParkingSpaces() {
        return data.getAllParkingSpaces();
    }

    @Override
    public List<ParkingSpace> getAllAvailableParkingSpaces() {
        return data.getAllAvailableParkingSpaces();
    }

    @Override
    public void updateParkingSpace(ParkingSpace parkingSpace) throws ParkingSpaceNotFoundException {
        data.updateParkingSpace(parkingSpace);
    }

    @Override
    public void addParkingSpace(ParkingSpace parkingSpace) {
        data.addParkingSpace(parkingSpace);
    }

    @Override
    public void deleteParkingSpace(int id) throws ParkingSpaceNotFoundException {
        data.deleteParkingSpace(id);
    }

    @Override
    public void deleteAll() {
        data.deleteAll();
    }

    /**
     * Get all parkingspaces that have been created by this user.
     *
     * @param selectedCustomer User whose parkingspaces to list.
     * @return All parkingspaces that have been created by this user
     */
    @Override
    public List<ParkingSpace> getAllParkingSpaces(Customer selectedCustomer) {
        return data.getAllParkingSpaces(selectedCustomer);
    }
}
