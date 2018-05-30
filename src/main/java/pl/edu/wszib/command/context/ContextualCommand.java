package pl.edu.wszib.command.context;

import pl.edu.wszib.command.Command;
import pl.edu.wszib.command.CommandResult;

public class ContextualCommand<R extends CommandResult> extends Command<R> {

    protected CommandContext commandContext;

    public ContextualCommand(CommandContext commandContext) {
        this.commandContext = commandContext;
    }

    public CommandContext getCommandContext() {
        return commandContext;
    }
}
