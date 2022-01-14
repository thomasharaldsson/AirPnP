package com.airpnp.controller;

import com.airpnp.authorization.loggedinuser.IAuthenticationFacade;
import com.airpnp.authorization.proxy.UserPrincipal;
import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.ParkingSpace;
import com.airpnp.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @RequestMapping(value = "/showall", method = RequestMethod.GET)
    public ModelAndView showAllParkingspace() {

        UserPrincipal user = authenticationFacade.getAuthenticatedUser();

        if (user != null) {
            System.out.println("Currently logged in customer has user id=" + user);
        }

        List<ParkingSpace> allParkingSpaces = parkingSpaceService.getAllParkingSpaces();
        return new ModelAndView("parkingspace/showAll", "parkingSpaces", allParkingSpaces);
    }

    @GetMapping(value = "/edit/{id}")
    @ResponseBody
    public ModelAndView editParkingspace(@PathVariable(required = true) int id) throws ParkingSpaceNotFoundException {
        System.out.println("Editing parkingspace ID=" + id);

        ParkingSpace parkingspace = parkingSpaceService.getParkingSpaceById(Integer.valueOf(id));
        ModelAndView modelAndView = new ModelAndView("parkingspace/createAndEdit");
        modelAndView.addObject("parkingspace", parkingspace);
        modelAndView.addObject("edit", Boolean.valueOf(true));
        modelAndView.addObject("action", "/parkingspace/edit");

        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editParkingspace(ParkingSpace parkingspace) throws ParkingSpaceNotFoundException {
        parkingSpaceService.updateParkingSpace(parkingspace);
        return "redirect:/parkingspace/showall";
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteParkingspace(@PathVariable(required = true) int id) throws ParkingSpaceNotFoundException {
        System.out.println("Deleting parkingspace ID=" + id);
        parkingSpaceService.deleteParkingSpace(id);
        return "redirect:/parkingspace/showall";
    }


    //TODO: Add missing RequestMethod
    @GetMapping("/show/{id}")
    @ResponseBody
    public ModelAndView showParkingspace(@PathVariable(required = true) int id) throws ParkingSpaceNotFoundException {
        ParkingSpace parkingspace = parkingSpaceService.getParkingSpaceById(Integer.valueOf(id));
        return new ModelAndView("parkingspace/showOne", "parkingspace", parkingspace);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createParkingspace() {
        ParkingSpace parkingSpace = new ParkingSpace(35, new Date(), new Date(), "Sparregatan 10");
        ModelAndView modelAndView = new ModelAndView("parkingspace/createAndEdit", "parkingspace", parkingSpace);
        modelAndView.addObject("action", "");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createParkingspace(ParkingSpace parkingspace) {
        parkingSpaceService.addParkingSpace(parkingspace);
        return "redirect:/parkingspace/showall";
    }

    public void lendParkingspace() {
        //TODO
    }

    @ExceptionHandler(ParkingSpaceNotFoundException.class)
    public ModelAndView handleException(ParkingSpaceNotFoundException ex) {
        //Do something additional if required
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("parkingspace/error");
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }


    /**
     *
     * @return username of logged in user. Or null if no user is logged in.
     */
    String getCurrentlyLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }

        return null;
    }

}
