package pl.edu.wszib.customer.command;

import org.springframework.data.domain.Pageable;
import pl.edu.wszib.command.context.CommandContext;
import pl.edu.wszib.command.context.ContextualCommand;
import pl.edu.wszib.customer.command.result.GetPageableCustomerListCommandResult;

public class GetPageableCustomerListCommand extends ContextualCommand<GetPageableCustomerListCommandResult> {

    private Pageable pageable;

    public GetPageableCustomerListCommand(CommandContext commandContext, Pageable pageable) {
        super(commandContext);
        this.pageable = pageable;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }
}
