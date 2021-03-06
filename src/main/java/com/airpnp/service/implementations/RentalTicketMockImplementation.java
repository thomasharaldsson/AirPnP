package com.airpnp.service.implementations;

import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.data.repository.RentalTicketRepository;
import com.airpnp.domainmodel.*;
import com.airpnp.service.ParkingSpaceService;
import com.airpnp.service.RentalTicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalTicketMockImplementation implements RentalTicketService {

    @Autowired
    private RentalTicketRepository data;

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    Map<Integer, RentalTicket> rentalTickets;
    public RentalTicketMockImplementation() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        rentalTickets = new HashMap<>();
        try {
            Customer currentCustomer = new Customer("George", "Silvant", "gs@france.com", "+99-234-7344", "123", "123", new Rating(3), false);
            Vehicle vehicle = new Vehicle("ABC-123", currentCustomer, null);
            rentalTickets.put(1, new RentalTicket(currentCustomer, vehicle, new ParkingSpace(35, dateFormatter.parse("2020-03-07"), dateFormatter.parse("2020-03-14"), "Götaplatsen 3", currentCustomer)));
        } catch (Exception e) {

        }

    }

    //MUST CHANGE BEAN
    @Override
    public void addRentalTicket(RentalTicket rentalTicket) throws ParkingSpaceNotFoundException {

        data.save(rentalTicket);
        try {
            ParkingSpace toUpdate = parkingSpaceService.getParkingSpaceById(rentalTicket.getParkingSpace().getId());
            //toUpdate.setTicket(rentalTicket);
            parkingSpaceService.updateParkingSpace(toUpdate);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteRentalTicket(int id) {
        try {
            ParkingSpace toUpdate = parkingSpaceService.getParkingSpaceById(data.getById(id).getParkingSpace().getId());
            //toUpdate.setTicket(null);
            parkingSpaceService.updateParkingSpace(toUpdate);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        data.delete(this.getRentalTicket(id));

    }

    @Override
    public RentalTicket getRentalTicket(int id ) {
        return data.findById(id).get();
    }

    @Override
    public List<RentalTicket> getRentalTicketsByCustomerId(Customer customer) {
        return null;
    }

    @Override
    public void deleteAll() {
        // TODO: implement method.
    }

    @Override
    public List<RentalTicket> getAllRentalTicketsCurrentUser() {
        return data.findAll();
    }

    @Override
    public List<RentalTicket> getRentalTicketsByParkingSpace(ParkingSpace parkingSpace) {
        List<RentalTicket> toReturn = new ArrayList<>();
        List<RentalTicket> alLRentalTickets = data.findAll();
        for (RentalTicket rt: alLRentalTickets) {
            if(rt.getParkingSpace().getStreetAddress().trim().equalsIgnoreCase(parkingSpace.getStreetAddress().trim())) {
                toReturn.add(rt);
            }
        }
        return toReturn;
    }
}
