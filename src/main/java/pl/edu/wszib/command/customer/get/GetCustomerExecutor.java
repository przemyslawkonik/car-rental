package pl.edu.wszib.command.customer.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.command.CommandExecutor;
import pl.edu.wszib.domain.repository.CustomerRepository;

@Component
public class GetCustomerExecutor implements CommandExecutor<GetCustomerCommand, GetCustomerResponse> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public GetCustomerResponse execute(GetCustomerCommand command) {
        return new GetCustomerResponse(customerRepository.findOne(command.getId()));
    }
}
