package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.command.customer.get.GetCustomerResponse;
import pl.edu.wszib.command.customer.get.GetPageableCustomerListResponse;
import pl.edu.wszib.command.customer.post.AddCustomerResponse;
import pl.edu.wszib.command.customer.put.EditCustomerResponse;
import pl.edu.wszib.domain.entity.Customer;
import pl.edu.wszib.service.CustomerService;
import pl.edu.wszib.util.Const;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<GetPageableCustomerListResponse> getCustomers(@RequestParam(value = "page", defaultValue = Const.DEFAULT_PAGE) int page,
                                                                        @RequestParam(value = "size", defaultValue = Const.DEFAULT_PAGE_SIZE) int size,
                                                                        @RequestParam(value = "sort", defaultValue = Const.DEFAULT_SORT) String[] properties,
                                                                        @RequestParam(value = "dir", defaultValue = Const.DEFAULT_SORT_DIRECTION) String direction) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.fromString(direction), properties);
        return ResponseEntity.ok(customerService.getCustomers(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCustomerResponse> getCustomerById(@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping("")
    public ResponseEntity<AddCustomerResponse> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditCustomerResponse> editCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        return ResponseEntity.ok(customerService.editCustomer(customer));
    }
}
