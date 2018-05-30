package pl.edu.wszib.customer.command.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.command.CommandExecutor;
import pl.edu.wszib.customer.command.GetCustomerCommand;
import pl.edu.wszib.customer.command.result.GetCustomerCommandResult;
import pl.edu.wszib.domain.repository.CustomerRepository;

@Component
public class GetCustomerCommandExecutor implements CommandExecutor<GetCustomerCommand, GetCustomerCommandResult> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public GetCustomerCommandResult execute(GetCustomerCommand command) {
        return new GetCustomerCommandResult(customerRepository.findOne(command.getId()));
    }
}
