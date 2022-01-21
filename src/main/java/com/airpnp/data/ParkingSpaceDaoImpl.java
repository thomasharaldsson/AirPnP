package com.airpnp.data;

import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.data.repository.ParkingSpaceRepository;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.domainmodel.RentalTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ParkingSpaceDaoImpl implements ParkingSpaceDao {

    @Autowired
    private ParkingSpaceRepository data;

    @PersistenceContext
    private EntityManager em;

    private final static String JPA_QUERY_GET_ALL_AVAILABLE_PARKINGSPACES = "SELECT p FROM ParkingSpace p WHERE p NOT IN (SELECT t.parkingSpace FROM RentalTicket t)";
    private final static String JPA_QUERY_PARKINGSPACE_IS_AVAILABLE = "SELECT t.parkingSpace FROM RentalTicket t WHERE t.parkingSpace =:parkingSpace";

    @Override
    public ParkingSpace getParkingSpaceById(Integer id) throws ParkingSpaceNotFoundException {
        if (data.findById(id).isPresent()) {
            return data.findById(id).get();
        } else {
            throw new ParkingSpaceNotFoundException("There is no parking space with id = " + id + ".");
        }
    }

    @Override
    public List<ParkingSpace> getAllParkingSpaces() {
        return data.findAll();
    }

    @Override
    public List<ParkingSpace> getAllAvailableParkingSpaces() {
        return em.createQuery(JPA_QUERY_GET_ALL_AVAILABLE_PARKINGSPACES).getResultList();
    }

    @Override
    public boolean parkingSpaceIsAvailable(ParkingSpace parkingSpace) {
         List<RentalTicket> tickets = em.createQuery(JPA_QUERY_PARKINGSPACE_IS_AVAILABLE).setParameter("parkingSpace", parkingSpace).getResultList();
         if (tickets.size() == 0) {
             return true;
         } else {
             return false;
         }
    }

    @Override
    public void updateParkingSpace(ParkingSpace parkingSpace) throws ParkingSpaceNotFoundException {
        Integer id = parkingSpace.getId();
        if (!data.existsById(id)) {
            throw new ParkingSpaceNotFoundException("Unable to update space since parkingspace with that id=" + id + " doesn't exist");
        }
        data.save(parkingSpace);
    }

    @Override
    public void addParkingSpace(ParkingSpace parkingSpace) {
        if (parkingSpace == null) {
            throw new NoSuchElementException("Can not add empty value");
        } else {
            data.save(parkingSpace);
        }
    }

    @Override
    public void deleteParkingSpace(int id) throws ParkingSpaceNotFoundException {
        data.delete(this.getParkingSpaceById(id));
    }

    @Override
    public void deleteAll() {
        data.deleteAll();
    }
}
