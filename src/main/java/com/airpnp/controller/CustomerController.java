package com.airpnp.controller;

import com.airpnp.data.exception.CustomerNotFoundException;
import com.airpnp.data.exception.ParkingSpaceNotFoundException;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Rating;
import com.airpnp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    //This method will save the customer into the database
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String newCustomer(Customer customer) {
        service.addCustomer(customer);
        return "redirect:/customer/showAll";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createCustomer() {
        //Customer customer = new Customer(3, "Bosse", "Svensson", "boknows@hotmail.com", "0735551533");
        Customer customer = new Customer();

        customer.setFirstName("Bosse");
        customer.setSurName("Bossesson");
        customer.setPhoneNumber("0735551533");
        customer.setEmail("boknows@hotmail.com");
        customer.addRating(new Rating(3));
        customer.addRating(new Rating(5));
        ModelAndView modelAndView = new ModelAndView("customer/createAndEdit", "customer", customer);
        modelAndView.addObject("action", "");
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    @ResponseBody
    public ModelAndView editCustomer(@PathVariable(required = true) int id) throws CustomerNotFoundException {
        System.out.println("Editing customer ID=" + id);

        Customer customer = service.getCustomer(Integer.valueOf(id));
        ModelAndView modelAndView = new ModelAndView("customer/createAndEdit", "customer", customer);
        modelAndView.addObject("edit", Boolean.valueOf(true));
        modelAndView.addObject("action", "/customer/edit");

        return modelAndView;
    }

    //TODO: Add missing RequestMethod
    @GetMapping("/show/{id}")
    @ResponseBody
    public ModelAndView showCustomer(@PathVariable(required = true) int id) throws CustomerNotFoundException {
        Customer customer = service.getCustomer(id);
        // Problem: previous line is not returning a proper object from DB.
        return new ModelAndView("customer/showOne", "customer", customer);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editCustomer(Customer customer) throws ParkingSpaceNotFoundException {
        service.update(customer);
        return "redirect:/customer/showall";
    }

    //Responsible for listing all of the Customers
    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public ModelAndView listAllCustomers() {

        //List<Customer> allCustomers = data.findAll();

        /*
        Customer newCustomer = new Customer();
        newCustomer.setFirstName("Bosse");
        newCustomer.setSurName("Bossesson");
        newCustomer.addRating(new Rating(3));
        newCustomer.addRating(new Rating(5));
        allCustomers.add(newCustomer);
    */

        //return new ModelAndView("customer/allCustomers", "customers", allCustomers);
        List<Customer> allCustomers = service.getAll();
        return new ModelAndView("customer/allCustomers", "customers", allCustomers);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ModelAndView handleException(CustomerNotFoundException ex) {
        //Do something additional if required
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/error");
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }
}
