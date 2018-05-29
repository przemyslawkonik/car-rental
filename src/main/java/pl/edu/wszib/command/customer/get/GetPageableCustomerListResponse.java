package pl.edu.wszib.command.customer.get;

import org.springframework.data.domain.Page;
import pl.edu.wszib.domain.entity.Customer;

public class GetPageableCustomerListResponse {

    private Page<Customer> customerList;

    public GetPageableCustomerListResponse(Page<Customer> customerList) {
        this.customerList = customerList;
    }

    public Page<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(Page<Customer> customerList) {
        this.customerList = customerList;
    }
}
