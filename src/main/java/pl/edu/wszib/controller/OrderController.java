package pl.edu.wszib.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.domain.entity.Car;
import pl.edu.wszib.domain.entity.Customer;
import pl.edu.wszib.domain.entity.Employee;
import pl.edu.wszib.domain.entity.Order;
import pl.edu.wszib.domain.repository.OrderRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private static final Logger logger = LogManager.getLogger(CarController.class);

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public List<Order> getAllOrders() {
        logger.info("Retrieving all orders from database");
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        logger.info("Retrieving order with id: " + id);
        return orderRepository.findById(id);
    }

    @GetMapping("/{rentalDate}")
    public Order getOrderByRentalDate(@PathVariable Date rentalDate) {
        logger.info("Retrieving ordes with rental date: " + rentalDate);
        return orderRepository.findByRentalDate(rentalDate);
    }

    @GetMapping("/{returnDate}")
    public Order getOrderBy(@PathVariable Date returnDate) {
        logger.info("Retrieving ordes with return date: " + returnDate);
        return orderRepository.findByReturnDate(returnDate);
    }

    @GetMapping("/{status}")
    public Order getOrderBy(@PathVariable String status) {
        logger.info("Retrieving ordes with status: " + status);
        return orderRepository.findByStatus(status);
    }

    @GetMapping("/{customer}")
    public Order getOrderBy(@PathVariable Customer customer) {
        logger.info("Retrieving orders of customer: " + customer);
        return orderRepository.findByCustomer(customer);
    }

    @GetMapping("/{employee}")
    public Order getOrderBy(@PathVariable Employee employee) {
        logger.info("Retrieving ordes of employee: " + employee);
        return orderRepository.findByEmployee(employee);
    }

    @GetMapping("/{car}")
    public Order getOrderBy(@PathVariable Car car) {
        logger.info("Retrieving ordes with car: " + car);
        return orderRepository.findByCar(car);
    }

    @PostMapping("/")
    public Order addOrder(@RequestBody Order order) {
        logger.info("Adding new order");
        return orderRepository.save(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Integer id, @RequestBody Order orderDetails) {
        logger.info("Updating order with id: " + id);
        Order order = orderRepository.findById(id);
        order.copyFieldsState(orderDetails);
        Order updatedOrder = orderRepository.save(order);

        return updatedOrder;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Integer id) {
        logger.info("Removing order with id: " + id);

        Order order = orderRepository.findById(id);
        orderRepository.delete(order);

        return ResponseEntity.ok().build();
    }
}

