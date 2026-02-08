package ucad.sn.customerservice.service;


import org.springframework.stereotype.Service;
import ucad.sn.customerservice.entities.Customer;
import ucad.sn.customerservice.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer not found"));
    }

   public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
