package com.lauri.FakeItunes.controllers;

import com.lauri.FakeItunes.models.Customer;
import com.lauri.FakeItunes.dataaccess.CustomerRepository;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;


public class CustomerController {

    // Configure some endpoints to manage crud
    private CustomerRepository customerRepository = new CustomerRepository();

    // This returns all the customers in the database
    @RequestMapping(value="/api/bar", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    // This adds a new customer - taking new customer from body of request
    @RequestMapping(value = "api/bar", method = RequestMethod.POST)
    public Boolean addNewCustomer(@RequestBody Customer customer){
        return customerRepository.addCustomer(customer);
    }

    // This updates a specified existing customer - taking new customer data from body of request
    @RequestMapping(value = "api/bar/{CustomerId}", method = RequestMethod.PUT)
    public Boolean updateExistingCustomer(@PathVariable String CustomerId, @RequestBody Customer customer){
        return customerRepository.updateCustomer(customer);
    }

    // This returns customer with specified CustomerId
    @RequestMapping(value = "api/bar", method = RequestMethod.GET)
    public Customer getCustomerByQueryId(@RequestParam(value="CustomerId", defaultValue = "ALF") String id){
        return customerRepository.getCustomerById(id);
    }

    // This returns number of customers in each country (not in descending order unfortunately!)
    @RequestMapping(value="/api/bar", method = RequestMethod.GET)
    public HashMap<String,Integer> getNumberOfCustomersByCountry(){
        return customerRepository.getNumberOfCustomersByCountry();
    }
}
