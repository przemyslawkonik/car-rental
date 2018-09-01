package pl.edu.wszib.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.edu.wszib.command.context.CommandContextFactory;
import pl.edu.wszib.command.dispatcher.CommandDispatcher;
import pl.edu.wszib.customer.command.AddCustomerCommand;
import pl.edu.wszib.customer.command.EditCustomerCommand;
import pl.edu.wszib.customer.command.GetCustomerCommand;
import pl.edu.wszib.customer.command.GetPageableCustomerListCommand;
import pl.edu.wszib.customer.command.result.AddCustomerCommandResult;
import pl.edu.wszib.customer.command.result.EditCustomerCommandResult;
import pl.edu.wszib.customer.command.result.GetCustomerCommandResult;
import pl.edu.wszib.customer.command.result.GetPageableCustomerListCommandResult;
import pl.edu.wszib.domain.entity.Customer;

@Service
public class CustomerService {

    @Autowired
    private CommandDispatcher commandDispatcher;

    @Autowired
    private CommandContextFactory commandContextFactory;

    public GetPageableCustomerListCommandResult getCustomers(Pageable pageable) {
        GetPageableCustomerListCommand command = new GetPageableCustomerListCommand(commandContextFactory.getCommandContext(), pageable);
        return commandDispatcher.execute(command);
    }

    public GetCustomerCommandResult getCustomerById(Integer id) {
        GetCustomerCommand command = new GetCustomerCommand(commandContextFactory.getCommandContext(), id);
        return commandDispatcher.execute(command);
    }

    public GetCustomerCommandResult getCustomerByEmail(String email) {
        GetCustomerCommand command = new GetCustomerCommand(commandContextFactory.getCommandContext(), email);
        return commandDispatcher.execute(command);
    }

    public AddCustomerCommandResult addCustomer(Customer customer) {
        AddCustomerCommand command = new AddCustomerCommand(commandContextFactory.getCommandContext(), customer);
        return commandDispatcher.execute(command);
    }

    public EditCustomerCommandResult editCustomer(Customer customer) {
        EditCustomerCommand command = new EditCustomerCommand(commandContextFactory.getCommandContext(), customer);
        return commandDispatcher.execute(command);
    }
}
