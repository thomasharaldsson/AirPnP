package com.airpnp.controller;

import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.service.ParkingSpaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/parkingspace")
public class ParkingSpaceController {

    private ParkingSpaceService parkingSpaceService;

    @RequestMapping(value = "/showall", method = RequestMethod.GET)
    public ModelAndView showAllParkingspace() {
        //List<ParkingSpace> allParkingSpaces = parkingSpaceService.getAllParkingSpaces();
        return null;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createParkingspace() {
        return new ModelAndView("createParkingSpace");
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ParkingSpace createParkingspace(Customer customer) {
        //TODO
        return null;
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
