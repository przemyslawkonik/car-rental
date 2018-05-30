package pl.edu.wszib.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.customer.command.result.AddCustomerCommandResult;
import pl.edu.wszib.customer.command.result.EditCustomerCommandResult;
import pl.edu.wszib.customer.command.result.GetCustomerCommandResult;
import pl.edu.wszib.customer.command.result.GetPageableCustomerListCommandResult;
import pl.edu.wszib.customer.service.CustomerService;
import pl.edu.wszib.domain.entity.Customer;
import pl.edu.wszib.util.Const;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<GetPageableCustomerListCommandResult> getCustomers(@RequestParam(value = "page", defaultValue = Const.DEFAULT_PAGE) int page,
                                                                             @RequestParam(value = "size", defaultValue = Const.DEFAULT_PAGE_SIZE) int size,
                                                                             @RequestParam(value = "sort", defaultValue = Const.DEFAULT_SORT) String[] properties,
                                                                             @RequestParam(value = "dir", defaultValue = Const.DEFAULT_SORT_DIRECTION) String direction) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.fromString(direction), properties);
        return ResponseEntity.ok(customerService.getCustomers(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCustomerCommandResult> getCustomerById(@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping("")
    public ResponseEntity<AddCustomerCommandResult> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditCustomerCommandResult> editCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        return ResponseEntity.ok(customerService.editCustomer(customer));
    }
}
