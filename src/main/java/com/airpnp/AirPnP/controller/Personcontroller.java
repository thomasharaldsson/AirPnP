package com.airpnp.AirPnP.controller;

import com.airpnp.AirPnP.domain.Person;
import com.airpnp.AirPnP.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/website/customers")
public class Personcontroller {

    @Autowired
    private Person data;

    //This method will save the customer into the database
    @RequestMapping(value = "/newController.html", method = RequestMethod.POST)
    public String newCustomer(Customer customer) {
        data.save(customer);
        return "redirect:/website/customers/list.html";
    }


    //Responsible for listing all of the Customers
    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public ModelAndView listAllCustomers() {
        List<Customer> allCustomers = data.findAll();

        Customer newCustomer = new Customer();
        newCustomer.setSurName("Bosse");
        newCustomer.setSurName("Bossesson");
        allCustomers.add(newCustomer);

        return new ModelAndView("allCustomers", "customers", allCustomers);
    }

    //Search for a vehicle by its name
    @RequestMapping(value = "/customer/{name}")
    public ModelAndView showCustomerByName(@PathVariable("name") String name) {

        return null;

    }
}
