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
    public List<Order> getOrdersByRentalDate(@PathVariable Date rentalDate) {
        logger.info("Retrieving orders with rental date: " + rentalDate);
        return orderRepository.findAllByRentalDate(rentalDate);
    }

    @GetMapping("/{returnDate}")
    public List<Order> getOrdersByReturnDate(@PathVariable Date returnDate) {
        logger.info("Retrieving orders with return date: " + returnDate);
        return orderRepository.findAllByReturnDate(returnDate);
    }

    @GetMapping("/{status}")
    public List<Order> getOrdersByStatus(@PathVariable String status) {
        logger.info("Retrieving orders with status: " + status);
        return orderRepository.findAllByStatus(status);
    }

    @PostMapping("/customer")
    public List<Order> getOrdersOfCustomer(@RequestBody Customer customer) {
        logger.info("Retrieving orders of customer: " + customer);
        List<Order> result = orderRepository.findAllByCustomer(customer);
        return result;
    }

    @GetMapping("/{employee}")
    public List<Order> getOrdersByEmployee(@PathVariable Employee employee) {
        logger.info("Retrieving orders of employee: " + employee);
        return orderRepository.findAllByEmployee(employee);
    }

    @GetMapping("/{car}")
    public List<Order> getOrdersByCar(@PathVariable Car car) {
        logger.info("Retrieving orders with car: " + car);
        return orderRepository.findAllByCar(car);
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

