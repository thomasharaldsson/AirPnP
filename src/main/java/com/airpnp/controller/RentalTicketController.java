package com.airpnp.controller;

import com.airpnp.data.exception.CustomerNotFoundException;
import com.airpnp.data.exception.VehicleNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.RentalTicket;
import com.airpnp.domainmodel.Vehicle;
import com.airpnp.service.CustomerService;
import com.airpnp.service.RentalTicketService;
import com.airpnp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import static com.airpnp.authorization.SecurityConfig.USER_ROLE_CUSTOMER;

@Controller
@RequestMapping("/rentalticket")


public class RentalTicketController {

    @Autowired
    RentalTicketService rentalTicketService;

    @RequestMapping(value = "/showall", method = RequestMethod.GET)
    public ModelAndView showAllRentalTickets() {
        List<RentalTicket> allTickets = rentalTicketService.getAllRentalTickets();
        return new ModelAndView("rentalticket/showAll", "rentalTickets", allTickets);
    }


}
