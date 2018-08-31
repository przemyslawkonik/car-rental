package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.domain.entity.Employee;
import pl.edu.wszib.domain.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // I'm not adding fields which are using field idNumber from Employee class
    // - because I'm not sure do we really need it

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeRepository.findById(id);
    }

    @GetMapping("/{name}")
    public Employee getEmployeeByName(@PathVariable String name) {
        return employeeRepository.findByName(name);
    }

    @GetMapping("/{surname}")
    public Employee getEmployeeBySurname(@PathVariable String surname) {
        return employeeRepository.findBySurname(surname);
    }


}
