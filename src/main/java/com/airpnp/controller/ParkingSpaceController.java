package com.airpnp.controller;

import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/parkingspace")
public class ParkingSpaceController {

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    @RequestMapping(value = "/showall", method = RequestMethod.GET)
    public ModelAndView showAllParkingspace() {
        List<ParkingSpace> allParkingSpaces = parkingSpaceService.getAllParkingSpaces();
        return new ModelAndView("parkingspace/showAll", "parkingSpaces", allParkingSpaces);
    }

    @GetMapping("/show/{id}")
    @ResponseBody
    public ModelAndView showParkingspace(@PathVariable(required = true) int id) {
        try {
            System.out.println("parkingspace ID=" + id);
            ParkingSpace parkingspace = parkingSpaceService.getParkingSpaceById(Integer.valueOf(id));
            return new ModelAndView("parkingspace/showOne", "parkingspace", parkingspace);
        } catch (ParkingSpaceNotFoundException e) {
            return new ModelAndView("parkingspace/showOne");
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createParkingspace() {
        ParkingSpace parkingSpace = new ParkingSpace(5, 35, new Date(), new Date(), "Sparregatan 10");
        return new ModelAndView("parkingspace/create", "form", parkingSpace);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createParkingspace(ParkingSpace parkingspace) {
        System.out.println("Parkingspace received:" + parkingspace);
        parkingSpaceService.addParkingSpace(parkingspace);
        return "redirect:/parkingspace/showall";
    }

    public void deleteParkingspace() {
        //TODO
    }

    public void lendParkingspace() {
        //TODO
    }

}
