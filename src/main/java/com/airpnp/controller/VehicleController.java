package com.airpnp.controller;

import com.airpnp.authentication.proxy.UserPrincipal;
import com.airpnp.data.exception.CustomerNotFoundException;
import com.airpnp.data.exception.VehicleNotFoundException;
import com.airpnp.data.exception.VehicleTypeNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Vehicle;
import com.airpnp.domainmodel.VehicleType;
import com.airpnp.service.CustomerService;
import com.airpnp.service.VehicleService;
import com.airpnp.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.airpnp.authentication.SecurityConfig.USER_ROLE_ADMIN;
import static com.airpnp.authentication.SecurityConfig.USER_ROLE_CUSTOMER;

@Controller
@Secured({USER_ROLE_CUSTOMER, USER_ROLE_ADMIN})
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    VehicleTypeService vehicleTypeService;

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/showall", method = RequestMethod.GET)
    @Secured({USER_ROLE_ADMIN})
    public ModelAndView showAllVehicles() {
        Customer currentCustomer = UserPrincipal.getCurrentlyLoggedInUserPrincipal().getCustomer();
        List<Vehicle> allVehicles = vehicleService.getAll();
        ModelAndView modelAndView = new ModelAndView("vehicle/showAll", "vehicles", allVehicles);
        modelAndView.addObject("currentUser", currentCustomer);
        modelAndView.addObject("pageTitle", "All vehicles vehicles in AirPnP");
        return modelAndView;
    }

    @RequestMapping(value = "/showall/currentuser", method = RequestMethod.GET)
    public ModelAndView showAllVehiclesForCurrentUser() {
        Customer currentCustomer = UserPrincipal.getCurrentlyLoggedInUserPrincipal().getCustomer();
        List<Vehicle> allVehicles = vehicleService.getAll(currentCustomer);
        ModelAndView modelAndView = new ModelAndView("vehicle/showAll");
        modelAndView.addObject("vehicles", allVehicles);
        modelAndView.addObject("pageTitle", "All vehicles for username " + currentCustomer.getUsername());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createVehicle() {
        Customer currentCustomer = UserPrincipal.getCurrentlyLoggedInUserPrincipal().getCustomer();
        Vehicle vehicle = new Vehicle();
        vehicle.setId(null);
        List<Customer> allCustomers = customerService.getAll();
        ModelAndView modelAndView = new ModelAndView("vehicle/createAndEdit", "vehicle", vehicle);
        modelAndView.addObject("customers", allCustomers);
        modelAndView.addObject("vehicleTypes", vehicleTypeService.getAll());
        modelAndView.addObject("action", "");
        return modelAndView;

    }

    @GetMapping(value = "/edit/{id}")
    @ResponseBody
    public ModelAndView editVehicle(@PathVariable(required = true) int id) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleService.getVehicleById(Integer.valueOf(id));
        ModelAndView modelAndView = new ModelAndView("vehicle/createAndEdit");
        List<Customer> allCustomers = customerService.getAll();
        modelAndView.addObject("edit", Boolean.valueOf(true));
        modelAndView.addObject("vehicle", vehicle);
        modelAndView.addObject("vehicleTypes", vehicleTypeService.getAll());
        modelAndView.addObject("action", "/vehicle/edit");
        modelAndView.addObject("customers", allCustomers);

        return modelAndView;
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editVehicle(Vehicle vehicle, int owner_id, int type_id) throws VehicleNotFoundException, CustomerNotFoundException, VehicleTypeNotFoundException {
        Customer owner = customerService.getCustomer(owner_id);
        vehicle.setOwner(owner);
        VehicleType type = vehicleTypeService.getVehicleTypeById(type_id);
        vehicle.setType(type);
        vehicleService.updateVehicle(vehicle);
        return "redirect:/vehicle/showall";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createVehicle(Vehicle vehicle, int owner_id, int type_id) throws CustomerNotFoundException, VehicleTypeNotFoundException {
        Customer owner = customerService.getCustomer(owner_id);
        vehicle.setOwner(owner);
        VehicleType type = vehicleTypeService.getVehicleTypeById(type_id);
        vehicle.setType(type);
        vehicleService.addVehicle(vehicle);
        return "redirect:/vehicle/showall";
    }

    @GetMapping("/show/{id}")
    @ResponseBody
    public ModelAndView showVehicle(@PathVariable(required = true) int id) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleService.getVehicleById(Integer.valueOf(id));
        return new ModelAndView("vehicle/showOne", "vehicle", vehicle);
    }

    //TODO: Add proper exception handling
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        //Do something additional if required
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vehicle/error");
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicle(@PathVariable(required = true) int id) throws VehicleNotFoundException {
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicle/showall";
    }
}
