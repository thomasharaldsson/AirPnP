package com.airpnp.controller;

import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.domainmodel.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    @RequestMapping(value = "/showall", method = RequestMethod.GET)
    public ModelAndView showAllVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();
        Customer c1 = new Customer(3, "Björn", "Jonsson", "njorn@altavista.com", "555-6767");
        Customer c2 = new Customer(2, "George", "Silvant", "gs@france.com", "+99-234-7344");

        allVehicles.add(new Vehicle(4, "ABC-123", c1));
        allVehicles.add(new Vehicle(8, "GZF-223", c2));
        allVehicles.add(new Vehicle(5, "FFF-131", c2));
        //List<Vehicle> allVehicles = service.getAllVehicles();
        return new ModelAndView("vehicle/showAll", "vehicles", allVehicles);
    }

    //TODO: Add exception method

}
