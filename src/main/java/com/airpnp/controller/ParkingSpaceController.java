package com.airpnp.controller;

import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/parkingspace")
public class ParkingSpaceController {
    @Autowired
    private ParkingSpaceService parkingSpaceService;

    public ParkingSpaceController(ParkingSpaceService service) {
        this.parkingSpaceService = service;
    }

    @RequestMapping(value = "/showall", method = RequestMethod.GET)
    public ModelAndView showAllParkingspace() {
        List<ParkingSpace> allParkingSpaces = parkingSpaceService.getAllParkingSpaces();
        return new ModelAndView("parkingspace/listAll", "parkingSpaces", allParkingSpaces);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createParkingspace() {
        ParkingSpace parkingSpace = new ParkingSpace(5, 35, new Date(), new Date(), "Sparregatan 10");
        return new ModelAndView("parkingspace/create", "form", parkingSpace);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createParkingspace(ParkingSpace parkingspace) {
        System.out.println("Parkingspace received:" + parkingspace);
        parkingSpaceService.addParkingSpace(parkingspace);
    }

    public void deleteParkingspace() {
        //TODO
    }

    public void lendParkingspace() {
        //TODO
    }

    public void setParkingSpaceService(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }
}
