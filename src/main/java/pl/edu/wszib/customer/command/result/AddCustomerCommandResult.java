package pl.edu.wszib.customer.command.result;

import pl.edu.wszib.command.CommandResult;
import pl.edu.wszib.domain.entity.Customer;

public class AddCustomerCommandResult extends CommandResult {

    private Customer customer;

    public AddCustomerCommandResult(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
