package pl.edu.wszib.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.domain.entity.Car;
import pl.edu.wszib.domain.entity.Customer;
import pl.edu.wszib.domain.entity.Order;
import pl.edu.wszib.domain.repository.CarRepository;
import pl.edu.wszib.domain.repository.CustomerRepository;
import pl.edu.wszib.domain.repository.OrderRepository;
import pl.edu.wszib.util.Const;
import pl.edu.wszib.util.CookieUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private static final Logger logger = LogManager.getLogger(CarController.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("")
    public List<Car> getAllCars() {
        logger.info("Retrieving all cars from database");
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Integer id) {
        logger.info("Retrieving car with id: " + id);
        return carRepository.findById(id);
    }

    @GetMapping("/{servicedate}")
    public List<Car> getCarByServicedate(@PathVariable String servicedate) {
        logger.info("Retrieving cars with service date: " + servicedate);
        return carRepository.findAllByServiceDate(servicedate);
    }

    @GetMapping("/{rentprice}")
    public List<Car> getCarByRentPrice(@PathVariable String rentprice) {
        logger.info("Retrieving cars with rent price: " + rentprice);
        return carRepository.findAllByRentPrice(rentprice);
    }

    @GetMapping("/{cartype}")
    public List<Car> getCarByCarType(@PathVariable String cartype) {
        logger.info("Retrieving cars type of: " + cartype);
        return carRepository.findAllByCarType(cartype);
    }

    @PostMapping("/")
    public Car addCar(@RequestBody Car car) {
        logger.info("Adding car");
        return carRepository.save(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Integer id, @RequestBody Car carDetails) {
        logger.info("Updating car with id: " + id);

        Car car = carRepository.findById(id);
        car.copyFieldsState(carDetails);
        Car updatedCar = carRepository.save(car);

        return updatedCar;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Integer id) {
        logger.info("Removing car with id: " + id + " from database");

        Car car = carRepository.findById(id);
        carRepository.delete(car);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/rent/{carId}")
    public ResponseEntity<Boolean> rentCar(@RequestBody Order order, @PathVariable Integer carId, HttpServletRequest request) {
        Car car = carRepository.findOne(carId);
        Optional<Cookie> cookie = CookieUtils.getCookie(request, Const.CUSTOMER_SESSION_ID);
        Integer customerId = cookie.isPresent() ? Integer.parseInt(cookie.get().getValue()) : null;
        Customer customer = customerRepository.findOne(customerId);

        order.setCar(car);
        order.setCustomer(customer);
        orderRepository.save(order);

        return ResponseEntity.ok(Boolean.TRUE);
    }
}
