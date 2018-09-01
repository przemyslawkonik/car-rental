package pl.edu.wszib.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.domain.entity.Address;
import pl.edu.wszib.domain.repository.AddressRepository;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class AddressController {
    private static final Logger logger = LogManager.getLogger(CarController.class);

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/{customerId}/address")
    public Address getAddressByCustomerId(@PathVariable Integer customerId) {
        logger.info("Retrieving address by customer id: " + customerId);
        return addressRepository.findByCustomerId(customerId);
    }

    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {
        logger.info("Retrieving all addresses");
        return addressRepository.findAll();
    }

    //todo: how to connect given address with particular customer ?!
    @PostMapping("/{customerId}/address")
    public Address addAddress (@PathVariable Integer customerId, @RequestBody Address address) {
        logger.info("Adding new address");
        return addressRepository.save(address);
    }

    //todo: how to update this address ?!
    @PutMapping("/{customerId}/address")
    public Address updateAddress (@PathVariable Integer customerId, @RequestBody Address address) {
        logger.info("Update new address");
        return addressRepository.save(address);
    }



}
