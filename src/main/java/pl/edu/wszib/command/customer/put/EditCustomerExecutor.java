package pl.edu.wszib.command.customer.put;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.command.CommandExecutor;
import pl.edu.wszib.domain.repository.CustomerRepository;

@Component
public class EditCustomerExecutor implements CommandExecutor<EditCustomerCommand, EditCustomerResponse> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public EditCustomerResponse execute(EditCustomerCommand command) {
        return new EditCustomerResponse(customerRepository.save(command.getCustomer()));
    }
}
