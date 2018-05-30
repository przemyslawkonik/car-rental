package pl.edu.wszib.customer.command.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.command.CommandExecutor;
import pl.edu.wszib.customer.command.AddCustomerCommand;
import pl.edu.wszib.customer.command.result.AddCustomerCommandResult;
import pl.edu.wszib.domain.repository.CustomerRepository;

@Component
public class AddCustomerCommandExecutor implements CommandExecutor<AddCustomerCommand, AddCustomerCommandResult> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public AddCustomerCommandResult execute(AddCustomerCommand command) {
        return new AddCustomerCommandResult(customerRepository.save(command.getCustomer()));
    }
}
