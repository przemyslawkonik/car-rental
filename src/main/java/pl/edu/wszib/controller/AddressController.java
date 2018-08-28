package pl.edu.wszib.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.domain.repository.AddressRepository;

public class AddressController {
    private static final Logger logger = LogManager.getLogger(CarController.class);

    @Autowired
    private AddressRepository addressRepository;




}
