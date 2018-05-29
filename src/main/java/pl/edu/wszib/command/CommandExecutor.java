package pl.edu.wszib.command;

public interface CommandExecutor<T, R> {
    R execute(T command);
}
