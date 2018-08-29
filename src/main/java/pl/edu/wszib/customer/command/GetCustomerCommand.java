package pl.edu.wszib.customer.command;

import pl.edu.wszib.command.context.CommandContext;
import pl.edu.wszib.command.context.ContextualCommand;
import pl.edu.wszib.customer.command.result.GetCustomerCommandResult;

public class GetCustomerCommand extends ContextualCommand<GetCustomerCommandResult> {

    private Integer id;
    private String username;
    private String email;

    public GetCustomerCommand(CommandContext commandContext) {
        super(commandContext);
    }

    public GetCustomerCommand(CommandContext commandContext, Integer id) {
        super(commandContext);
        this.id = id;
    }

    public GetCustomerCommand(CommandContext commandContext, String email) {
        super(commandContext);
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
