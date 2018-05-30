package pl.edu.wszib.customer.command;

import pl.edu.wszib.command.context.CommandContext;
import pl.edu.wszib.command.context.ContextualCommand;
import pl.edu.wszib.customer.command.result.AddCustomerCommandResult;
import pl.edu.wszib.domain.entity.Customer;

public class AddCustomerCommand extends ContextualCommand<AddCustomerCommandResult> {

    private Customer customer;

    public AddCustomerCommand(CommandContext commandContext, Customer customer) {
        super(commandContext);
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
