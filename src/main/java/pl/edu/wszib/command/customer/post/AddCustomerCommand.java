package pl.edu.wszib.command.customer.post;

import pl.edu.wszib.domain.entity.Customer;

public class AddCustomerCommand {

    private Customer customer;

    public AddCustomerCommand(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
