package com.airpnp.controller;

import com.airpnp.data.exception.CustomerNotFoundException;
import com.airpnp.data.exception.VehicleNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.domainmodel.RentalTicket;
import com.airpnp.domainmodel.Vehicle;
import com.airpnp.service.CustomerService;
import com.airpnp.service.ParkingSpaceService;
import com.airpnp.service.RentalTicketService;
import com.airpnp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

import static com.airpnp.authorization.SecurityConfig.USER_ROLE_CUSTOMER;

@Controller
@RequestMapping("/rentalticket")
public class RentalTicketController {

    @Autowired
    RentalTicketService rentalTicketService;

    @Autowired
    CustomerService customerService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    ParkingSpaceService parkingSpaceService;

    @RequestMapping(value = "/showall", method = RequestMethod.GET)
    public ModelAndView showAllRentalTickets() {
        List<RentalTicket> allTickets = rentalTicketService.getAllRentalTickets();
        return new ModelAndView("rentalticket/showAll", "rentalTickets", allTickets);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createRentalTicket() {
        RentalTicket rentalTicket = new RentalTicket(customerService.getAll().get(0), vehicleService.getAll().get(0), parkingSpaceService.getAllParkingSpaces().get(0));
        ModelAndView modelAndView = new ModelAndView("rentalticket/createAndEdit", "rentalticket", rentalTicket);
        modelAndView.addObject("action", "");
        modelAndView.addObject("listCustomer", customerService.getAll());
        modelAndView.addObject("listParkingSpace", parkingSpaceService.getAllParkingSpaces());
        modelAndView.addObject("listVehicle", vehicleService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createRentalTicket(int customer, int parkingSpace, int vehicle) {
        System.out.println("CUST" + customer);
        System.out.println("VEH" + parkingSpace);
        System.out.println("PS" + vehicle);
        boolean flag=true;
        for (RentalTicket ticket: rentalTicketService.getAllRentalTickets()
             ) {
            try {
                if (ticket.getParkingSpace().getStreetAddress().equals(parkingSpaceService.getParkingSpaceById(parkingSpace).getStreetAddress())) {
                    flag = false;
                }
            } catch (Exception e){

            }
        }
        try{
            if(flag){
                rentalTicketService.addRentalTicket(new RentalTicket(customerService.getCustomer(customer), vehicleService.getVehicleById(vehicle), parkingSpaceService.getParkingSpaceById(parkingSpace)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/rentalticket/showall";
    }


}
