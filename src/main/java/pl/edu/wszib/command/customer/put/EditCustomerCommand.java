package pl.edu.wszib.command.customer.put;

import pl.edu.wszib.domain.entity.Customer;

public class EditCustomerCommand {

    private Customer customer;

    public EditCustomerCommand(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
