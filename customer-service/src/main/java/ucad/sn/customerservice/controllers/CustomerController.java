package ucad.sn.customerservice.controllers;


import org.springframework.web.bind.annotation.*;
import ucad.sn.customerservice.entities.Customer;
import ucad.sn.customerservice.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("")
    List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    Customer findCustomerById(@PathVariable  Long id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping("")
    Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
}
