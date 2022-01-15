package com.airpnp.service.implementations;

import com.airpnp.data.ParkingSpaceRepository;
import com.airpnp.data.RentalTicketRepository;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.domainmodel.RentalTicket;
import com.airpnp.service.ParkingSpaceService;
import com.airpnp.service.RentalTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rentalTicketsServiceMock")
public class RentalTicketProductionImpl implements RentalTicketService {

    @Autowired
    private RentalTicketRepository data;

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    @Override
    public List<RentalTicket> getAllRentalTickets() {
        return data.findAll();
    }

    @Override
    public void addRentalTicket(RentalTicket rentalTicket) {
        data.save(rentalTicket);
        try {
            ParkingSpace toUpdate = parkingSpaceService.getParkingSpaceById(rentalTicket.getParkingSpace().getId());
            toUpdate.setTicket(rentalTicket);
            parkingSpaceService.updateParkingSpace(toUpdate);
            System.out.println("Prod impl");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Prod impl");
        }
    }

    @Override
    public RentalTicket getRentalTicket(int id ) {
        return data.findById(id).get();
    }

    @Override
    public void deleteRentalTicket(int id) {
        try {
            ParkingSpace toUpdate = parkingSpaceService.getParkingSpaceById(data.getById(id).getParkingSpace().getId());
            toUpdate.setTicket(null);
            parkingSpaceService.updateParkingSpace(toUpdate);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        data.delete(this.getRentalTicket(id));

    }

    @Override
    public void deleteAll() {
        data.deleteAll();
    }
}
