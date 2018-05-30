package pl.edu.wszib.customer.command;

import pl.edu.wszib.command.context.CommandContext;
import pl.edu.wszib.command.context.ContextualCommand;
import pl.edu.wszib.customer.command.result.GetCustomerCommandResult;

public class GetCustomerCommand extends ContextualCommand<GetCustomerCommandResult> {

    private int id;

    public GetCustomerCommand(CommandContext commandContext, int id) {
        super(commandContext);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
