package pl.edu.wszib.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.edu.wszib.authentication.wrapper.CustomUserDetails;
import pl.edu.wszib.command.context.CommandContextFactory;
import pl.edu.wszib.command.dispatcher.CommandDispatcher;
import pl.edu.wszib.customer.command.AddCustomerCommand;
import pl.edu.wszib.customer.command.GetCustomerCommand;
import pl.edu.wszib.customer.command.result.AddCustomerCommandResult;
import pl.edu.wszib.customer.command.result.EditCustomerCommandResult;
import pl.edu.wszib.customer.command.result.GetCustomerCommandResult;
import pl.edu.wszib.domain.entity.Customer;

import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private CommandDispatcher commandDispatcher;

    @Autowired
    private CommandContextFactory commandContextFactory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GetCustomerCommand command = new GetCustomerCommand(commandContextFactory.getCommandContext());
        command.setUsername(username);
        GetCustomerCommandResult result = commandDispatcher.execute(command);
        if(!Optional.ofNullable(result.getCustomer()).isPresent()) {
            command = new GetCustomerCommand(commandContextFactory.getCommandContext());
            command.setEmail(username);
            result = commandDispatcher.execute(command);
        }
        return new CustomUserDetails(result.getCustomer());
    }

    public AddCustomerCommandResult register(Customer customer, BindingResult bindingResult) {
        //TODO validation
        AddCustomerCommand command = new AddCustomerCommand(commandContextFactory.getCommandContext(), customer);
        return commandDispatcher.execute(command);
    }

    public EditCustomerCommandResult edit(Customer customer, BindingResult bindingResult) {
        //TODO validation
        //TODO command
        return null;
    }
}
