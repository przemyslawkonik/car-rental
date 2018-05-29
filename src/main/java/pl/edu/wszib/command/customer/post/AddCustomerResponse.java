package pl.edu.wszib.command.customer.post;

import pl.edu.wszib.domain.entity.Customer;

public class AddCustomerResponse {

    private Customer customer;

    public AddCustomerResponse(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
