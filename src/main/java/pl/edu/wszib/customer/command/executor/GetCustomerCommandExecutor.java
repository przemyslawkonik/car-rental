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
        Integer id = command.getId();
        String email = command.getEmail();
        String username = command.getUsername();

        if (id != null) {
            return new GetCustomerCommandResult(customerRepository.findOne(id));
        }
        if(username != null) {
            return new GetCustomerCommandResult(customerRepository.findByName(username));
        }
        if (email != null) {
            return new GetCustomerCommandResult(customerRepository.findByEmail(email));
        }
        return new GetCustomerCommandResult(null);
    }
}
