package pl.edu.wszib.command.customer.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pl.edu.wszib.command.CommandExecutor;
import pl.edu.wszib.domain.entity.Customer;
import pl.edu.wszib.domain.repository.CustomerRepository;

@Component
public class GetPageableCustomerListExecutor implements CommandExecutor<GetPageableCustomerListCommand, GetPageableCustomerListResponse> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public GetPageableCustomerListResponse execute(GetPageableCustomerListCommand command) {
        Page<Customer> response = customerRepository.findAll(command.getPageable());
        return new GetPageableCustomerListResponse(response);
    }
}
