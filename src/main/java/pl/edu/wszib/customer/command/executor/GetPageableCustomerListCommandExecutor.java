package pl.edu.wszib.customer.command.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pl.edu.wszib.command.CommandExecutor;
import pl.edu.wszib.customer.command.GetPageableCustomerListCommand;
import pl.edu.wszib.customer.command.result.GetPageableCustomerListCommandResult;
import pl.edu.wszib.domain.entity.Customer;
import pl.edu.wszib.domain.repository.CustomerRepository;

@Component
public class GetPageableCustomerListCommandExecutor implements CommandExecutor<GetPageableCustomerListCommand, GetPageableCustomerListCommandResult> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public GetPageableCustomerListCommandResult execute(GetPageableCustomerListCommand command) {
        Page<Customer> response = customerRepository.findAll(command.getPageable());
        return new GetPageableCustomerListCommandResult(response);
    }
}
