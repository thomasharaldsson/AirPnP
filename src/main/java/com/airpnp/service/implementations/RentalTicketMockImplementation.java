package com.airpnp.service.implementations;

import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.domainmodel.RentalTicket;
import com.airpnp.domainmodel.Vehicle;
import com.airpnp.service.RentalTicketService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("rentalTicketsServiceMock")

public class RentalTicketMockImplementation implements RentalTicketService {

    Map<Integer, RentalTicket> rentalTickets;
    public RentalTicketMockImplementation() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        rentalTickets = new HashMap<>();
        try {
            Customer currentCustomer = new Customer(2, "George", "Silvant", "gs@france.com", "+99-234-7344");
            Vehicle vehicle = new Vehicle(4, "ABC-123", currentCustomer);
            rentalTickets.put(1, new RentalTicket(1, currentCustomer, vehicle, new ParkingSpace(1, 35, dateFormatter.parse("2020-03-07"), dateFormatter.parse("2020-03-14"), "Götaplatsen 3")));
        } catch (Exception e) {

        }

    }
    @Override
    public void addRentalTicket(RentalTicket rentalTicket) {

    }

    @Override
    public List<RentalTicket> getAllRentalTickets() {
        return new ArrayList<>(rentalTickets.values());
    }
}
