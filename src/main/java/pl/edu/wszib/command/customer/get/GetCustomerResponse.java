package pl.edu.wszib.command.customer.get;

import pl.edu.wszib.command.CommandResponse;
import pl.edu.wszib.domain.entity.Customer;

public class GetCustomerResponse implements CommandResponse {

    private Customer customer;

    public GetCustomerResponse(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
