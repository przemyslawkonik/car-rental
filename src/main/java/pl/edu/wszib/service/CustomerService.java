package pl.edu.wszib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.edu.wszib.command.customer.get.*;
import pl.edu.wszib.command.customer.post.AddCustomerCommand;
import pl.edu.wszib.command.customer.post.AddCustomerExecutor;
import pl.edu.wszib.command.customer.post.AddCustomerResponse;
import pl.edu.wszib.command.customer.put.EditCustomerCommand;
import pl.edu.wszib.command.customer.put.EditCustomerExecutor;
import pl.edu.wszib.command.customer.put.EditCustomerResponse;
import pl.edu.wszib.domain.entity.Customer;

@Service
public class CustomerService {

    @Autowired
    private GetPageableCustomerListExecutor getPageableCustomerListExecutor;

    @Autowired
    private GetCustomerExecutor getCustomerExecutor;

    @Autowired
    private AddCustomerExecutor addCustomerExecutor;

    @Autowired
    private EditCustomerExecutor editCustomerExecutor;

    public GetPageableCustomerListResponse getCustomers(Pageable pageable) {
        return getPageableCustomerListExecutor.execute(new GetPageableCustomerListCommand(pageable));
    }

    public GetCustomerResponse getCustomerById(Integer id) {
        return getCustomerExecutor.execute(new GetCustomerCommand(id));
    }

    public AddCustomerResponse addCustomer(Customer customer) {
        return addCustomerExecutor.execute(new AddCustomerCommand(customer));
    }

    public EditCustomerResponse editCustomer(Customer customer) {
        return editCustomerExecutor.execute(new EditCustomerCommand(customer));
    }
}
