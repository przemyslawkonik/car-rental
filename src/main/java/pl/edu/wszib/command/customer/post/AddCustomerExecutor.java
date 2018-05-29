package pl.edu.wszib.command.customer.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.command.CommandExecutor;
import pl.edu.wszib.domain.repository.CustomerRepository;

@Component
public class AddCustomerExecutor implements CommandExecutor<AddCustomerCommand, AddCustomerResponse> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public AddCustomerResponse execute(AddCustomerCommand command) {
        return new AddCustomerResponse(customerRepository.save(command.getCustomer()));
    }
}
