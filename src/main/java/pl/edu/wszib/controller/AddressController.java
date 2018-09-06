package pl.edu.wszib.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.domain.entity.Address;
import pl.edu.wszib.domain.entity.Customer;
import pl.edu.wszib.domain.repository.AddressRepository;
import pl.edu.wszib.domain.repository.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class AddressController {

    private static final Logger logger = LogManager.getLogger(CarController.class);

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/{customerId}/address")
    public Address getAddressByCustomerId(@PathVariable Integer customerId) {
        logger.info("Retrieving address by customer id: " + customerId);
        Customer customer = customerRepository.findById(customerId);
        return customer.getAddress();
    }

    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {
        logger.info("Retrieving all addresses");
        return addressRepository.findAll();
    }

    // TODO: 06.09.18 : check is this a good way to implement put address
    @PutMapping("/{customerId}/address")
    public Address updateAddress (@PathVariable Integer customerId, @RequestBody Address updatedAddress) {
        logger.info("Update new address");
        Customer customer = customerRepository.findById(customerId);
        customer.setAddress(updatedAddress);
        customerRepository.save(customer);

        return customer.getAddress();
    }

    // TODO: 06.09.18 : do we need here POST address?! or we will be adding new addresses while creating new Customers?!

}
