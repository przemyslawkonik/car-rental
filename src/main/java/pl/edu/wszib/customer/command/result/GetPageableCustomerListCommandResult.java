package pl.edu.wszib.customer.command.result;

import org.springframework.data.domain.Page;
import pl.edu.wszib.command.CommandResult;
import pl.edu.wszib.domain.entity.Customer;

public class GetPageableCustomerListCommandResult extends CommandResult {

    private Page<Customer> customerList;

    public GetPageableCustomerListCommandResult(Page<Customer> customerList) {
        this.customerList = customerList;
    }

    public Page<Customer> getCustomerList() {
        return customerList;
    }
}
