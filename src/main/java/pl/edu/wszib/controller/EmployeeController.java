package pl.edu.wszib.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.domain.entity.Car;
import pl.edu.wszib.domain.entity.Employee;
import pl.edu.wszib.domain.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // I'm not adding fields which are using field idNumber from Employee class
    // - because I'm not sure do we really need it

    private static final Logger logger = LogManager.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        logger.info("Retrieving all employees from database");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        logger.info("Retrieving employee with id: " + id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/{name}")
    public Employee getEmployeeByName(@PathVariable String name) {
        logger.info("Retrieving employee with name: " + name);
        return employeeRepository.findByName(name);
    }

    @GetMapping("/{surname}")
    public Employee getEmployeeBySurname(@PathVariable String surname) {
        logger.info("Retrieving employee with surname: " + surname);
        return employeeRepository.findBySurname(surname);
    }

    @PostMapping("/")
    public Employee addEmployee(@RequestBody Employee employee) {
        logger.info("Adding employee");
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateCar(@PathVariable Integer id, @RequestBody Employee employeeDetails) {
        logger.info("Updating employee with id: " + id);

        Employee employee = employeeRepository.findById(id);
        employee.copyFieldsState(employeeDetails);
        Employee updatedEmployee = employeeRepository.save(employee);

        return updatedEmployee;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee (@PathVariable Integer id) {
        logger.info("Removing employee with id: " + id + " from database");

        Employee employee = employeeRepository.findById(id);
        employeeRepository.delete(employee);

        return ResponseEntity.ok().build();
    }

}
