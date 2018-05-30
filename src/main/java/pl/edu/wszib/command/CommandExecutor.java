package pl.edu.wszib.command;

public interface CommandExecutor<C extends Command, R extends CommandResult> {
    R execute(C command);
}
