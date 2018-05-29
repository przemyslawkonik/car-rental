package pl.edu.wszib.command.customer.put;

import pl.edu.wszib.domain.entity.Customer;

public class EditCustomerResponse {

    private Customer customer;

    public EditCustomerResponse(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
