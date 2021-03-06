package com.airpnp.service.implementations;

import com.airpnp.authentication.decorator.UserPrincipal;
import com.airpnp.data.RentalTicketDaoImpl;
import com.airpnp.data.repository.RentalTicketRepository;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.domainmodel.RentalTicket;
import com.airpnp.service.CustomerService;
import com.airpnp.service.ParkingSpaceService;
import com.airpnp.service.RentalTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("rentalTicketsServiceMock")
public class RentalTicketProductionImpl implements RentalTicketService {

    @Autowired
    private RentalTicketRepository data;

    @Autowired
    private RentalTicketDaoImpl rentalTicketDao;

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    @Autowired
    private CustomerService customerService;


    @Override
    public List<RentalTicket> getAllRentalTicketsCurrentUser() {
        int loggedInUserId = UserPrincipal.getCurrentlyLoggedInUserPrincipal().getCustomer().getId();
        return data.findAll().stream().filter( ticket -> {
            int ticketUserId = ticket.getCustomer().getId();
            return ticketUserId == loggedInUserId;
        }).collect(Collectors.toList());
    }

    @Override
    public void addRentalTicket(RentalTicket rentalTicket) {
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
    public RentalTicket getRentalTicket(int id ) {
        return data.findById(id).get();
    }

    @Override
    public List<RentalTicket> getRentalTicketsByCustomerId(Customer customer) {
        return rentalTicketDao.getAll(customer);
    }

    @Override
    public void deleteRentalTicket(int id) {
        data.deleteById(id);
        try {
            ParkingSpace toUpdate = parkingSpaceService.getParkingSpaceById(data.getById(id).getParkingSpace().getId());
            parkingSpaceService.updateParkingSpace(toUpdate);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        data.deleteAll();
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
