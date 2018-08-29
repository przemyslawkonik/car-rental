package pl.edu.wszib.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.domain.entity.Car;
import pl.edu.wszib.domain.entity.Customer;
import pl.edu.wszib.domain.repository.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private static final Logger logger = LogManager.getLogger(CarTypeController.class);

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        logger.info("Retrieving all customers");
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        logger.info("Retrieving customer by id: " + id);
        return customerRepository.findById(id);
    }

    @GetMapping("/name")
    public List<Customer> getCustomersByName(@PathVariable String name) {
        logger.info("Retrieving customer by name: " + name);
        return customerRepository.findByName(name);
    }

    @GetMapping("/surname")
    public List<Customer> getCustomersBySurname(@PathVariable String surname) {
        logger.info("Retrieving customer by surname: " + surname);
        return customerRepository.findBySurname(surname);
    }

    @GetMapping("/phone")
    public Customer getCustomerByPhone(@PathVariable String phone) {
        logger.info("Retrieving customer by phone: " + phone);
        return customerRepository.findByPhone(phone);
    }

    @GetMapping("/email")
    public Customer getCustomerByEmail(@PathVariable String email) {
        logger.info("Retrieving customer by email: " + email);
        return customerRepository.findByEmail(email);
    }

    @PostMapping("/")
    public Customer addCustomer(@RequestBody Customer customer) {
        logger.info("Adding customer");
        return customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customerDetail) {
        logger.info("Updating car with id: " + id);

        Customer customer = customerRepository.findById(id);
        customer.copyFieldsState(customerDetail);
        Customer updatedCustomer = customerRepository.save(customer);

        return updatedCustomer;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id) {
        Customer customer = customerRepository.findById(id);
        customerRepository.delete(customer);

        logger.info("Customer with id: " + id + " removed");
        return ResponseEntity.ok().build();
    }



}
