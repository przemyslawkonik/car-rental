package pl.edu.wszib.command.dispatcher;

import pl.edu.wszib.command.Command;
import pl.edu.wszib.command.CommandResult;

public interface CommandDispatcher {
    <R extends CommandResult> R execute(Command<R> command);
}
