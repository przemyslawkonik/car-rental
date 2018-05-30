package pl.edu.wszib.customer.command.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.command.CommandExecutor;
import pl.edu.wszib.customer.command.EditCustomerCommand;
import pl.edu.wszib.customer.command.result.EditCustomerCommandResult;
import pl.edu.wszib.domain.repository.CustomerRepository;

@Component
public class EditCustomerCommandExecutor implements CommandExecutor<EditCustomerCommand, EditCustomerCommandResult> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public EditCustomerCommandResult execute(EditCustomerCommand command) {
        return new EditCustomerCommandResult(customerRepository.save(command.getCustomer()));
    }
}
