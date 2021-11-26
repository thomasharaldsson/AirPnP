package com.airpnp.controller;

import com.airpnp.data.CustomerRepository;
import com.airpnp.domainmodel.Customer;
import com.airpnp.domainmodel.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerRepository data;

    //This method will save the customer into the database
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String newCustomer(Customer customer) {
        data.save(customer);
        return "redirect:/website/customers/list.html";
    }


    //Responsible for listing all of the Customers
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public ModelAndView listAllCustomers() {
        List<Customer> allCustomers = data.findAll();

        Customer newCustomer = new Customer();
        newCustomer.setFirstName("Bosse");
        newCustomer.setSurName("Bossesson");
        newCustomer.addRating(new Rating(3));
        newCustomer.addRating(new Rating(5));
        allCustomers.add(newCustomer);


        return new ModelAndView("customer/allCustomers", "customers", allCustomers);
    }

    /*
    //Search for a customer by its name
    @RequestMapping(value = "/customer/{name}")
    public ModelAndView showCustomerByName(@PathVariable("name") String name) {

        Customer customer= data.findByName(name);
        return new ModelAndView("customerInfo" , "customer", customer);
    }*/
}