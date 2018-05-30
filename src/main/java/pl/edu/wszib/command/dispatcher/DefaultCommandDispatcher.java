package pl.edu.wszib.command.dispatcher;

import pl.edu.wszib.command.Command;
import pl.edu.wszib.command.CommandExecutor;
import pl.edu.wszib.command.CommandResult;

import java.util.Map;

public class DefaultCommandDispatcher implements CommandDispatcher {

    protected Map<Class, CommandExecutor> executorMap;

    @Override
    public <R extends CommandResult> R execute(Command<R> command) {
        CommandExecutor executor = executorMap.get(command.getClass());
        return (R) executor.execute(command);
    }
}
