package com.airpnp.controller;

import com.airpnp.authorization.proxy.UserPrincipal;
import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.domainmodel.RentalTicket;
import com.airpnp.service.CustomerService;
import com.airpnp.service.ParkingSpaceService;
import com.airpnp.service.RentalTicketService;
import com.airpnp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
        List<RentalTicket> allTickets = rentalTicketService.getAllRentalTicketsCurrentUser();
        return new ModelAndView("rentalticket/showAll", "rentalTickets", allTickets);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createRentalTicket() {
        RentalTicket rentalTicket = new RentalTicket(customerService.getAll().get(0), vehicleService.getAll().get(0), parkingSpaceService.getAllParkingSpaces().get(0));
        ModelAndView modelAndView = new ModelAndView("rentalticket/create", "rentalticket", rentalTicket);
        modelAndView.addObject("action", "");
        modelAndView.addObject("listCustomer", customerService.getAll());
        modelAndView.addObject("listParkingSpace", parkingSpaceService.getAllAvailableParkingSpaces());
        modelAndView.addObject("listVehicle", vehicleService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/upcreate/{parkingSpaceId}", method = RequestMethod.GET)
    public ModelAndView createRentalTicket(@PathVariable(required = true) int parkingSpaceId) throws ParkingSpaceNotFoundException {
        ParkingSpace parkingSpace = parkingSpaceService.getParkingSpaceById(parkingSpaceId);
        Customer selectedCustomer = UserPrincipal.getCurrentlyLoggedInUserPrincipal().getCustomer();
        RentalTicket ticket = new RentalTicket();
        ticket.setParkingSpace(parkingSpace);
        ModelAndView modelAndView = new ModelAndView("rentalticket/create");
        modelAndView.addObject("rentalticket", ticket);
        modelAndView.addObject("action", "/rentalticket/create");
        modelAndView.addObject("selectedParkingSpace", parkingSpace);
        modelAndView.addObject("selectedCustomer", selectedCustomer);
        modelAndView.addObject("listVehicle", vehicleService.getAll());
        modelAndView.addObject("listCustomer", customerService.getAll());
        modelAndView.addObject("listParkingSpace", parkingSpaceService.getAllAvailableParkingSpaces());
        modelAndView.addObject("listVehicle", vehicleService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createRentalTicket(int customer, int parkingSpace, int vehicle) {
        System.out.println("CUST" + customer);
        System.out.println("VEH" + parkingSpace);
        System.out.println("PS" + vehicle);
        boolean flag=true;
        for (RentalTicket ticket: rentalTicketService.getAllRentalTicketsCurrentUser()
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

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteRentalTicket(@PathVariable(required = true) int id) {
        System.out.println("Deleting rentalticket ID=" + id);
        rentalTicketService.deleteRentalTicket(id);
        return "redirect:/rentalticket/showall";
    }


}
