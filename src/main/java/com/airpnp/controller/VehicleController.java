package com.airpnp.controller;

import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.domainmodel.Vehicle;
import com.airpnp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService service;

    @RequestMapping(value = "/showall", method = RequestMethod.GET)
    public ModelAndView showAllVehicles() {
        List<Vehicle> allVehicles = service.getAll();
        return new ModelAndView("vehicle/showAll", "vehicles", allVehicles);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createVehicle() {
        Customer currentCustomer = new Customer(2, "George", "Silvant", "gs@france.com", "+99-234-7344");
        Vehicle vehicle = new Vehicle(4, "ABC-123", currentCustomer);
        ModelAndView modelAndView = new ModelAndView("vehicle/createAndEdit", "vehicle", vehicle);
        modelAndView.addObject("action", "");
        return modelAndView;

    }

    //TODO: Add exception method

}
