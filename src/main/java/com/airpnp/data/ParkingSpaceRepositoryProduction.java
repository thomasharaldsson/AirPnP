package com.airpnp.data;

import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.data.repository.ParkingSpaceRepository;
import com.airpnp.data.repository.RentalTicketRepository;
import com.airpnp.domainmodel.ParkingSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ParkingSpaceRepositoryProduction implements ParkingSpaceDao {

    @Autowired
    private ParkingSpaceRepository data;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String QUERY_GET_ALL_AVAILABLE_PARKINGSPACES =
            "SELECT * FROM PARKING_SPACE AS p WHERE p.id NOT IN (SELECT PARKING_SPACE_ID FROM RENTAL_TICKET);";

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

        //return em.createQuery("select parkingSpace from ParkingSpace as parkingSpace").getResultList();
        return jdbcTemplate.query(
                QUERY_GET_ALL_AVAILABLE_PARKINGSPACES,
                (rs, rowNum) -> {
                        ParkingSpace parkingSpace = new ParkingSpace(
                        rs.getInt("price"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getString("street_address"));
                        parkingSpace.setId(rs.getInt("id"));
                        return parkingSpace;
                }
        );
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
