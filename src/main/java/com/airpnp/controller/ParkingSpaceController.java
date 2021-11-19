package com.airpnp.controller;

import com.airpnp.domain.Customer;
import com.airpnp.domain.ParkingSpace;
import com.airpnp.service.ParkingSpaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/park")
public class ParkingSpaceController {

    private ParkingSpaceService parkingSpaceService;

    @RequestMapping(value = "/parkingspaces", method = RequestMethod.GET)
    public ModelAndView showAllParkingspace() {
        //List<ParkingSpace> allParkingSpaces = parkingSpaceService.getAllParkingSpaces();
        return null;
    }

    @RequestMapping(value = "/createparking", method = RequestMethod.POST)
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
