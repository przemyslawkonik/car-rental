package pl.edu.wszib.command.context;

import org.springframework.stereotype.Component;

@Component
public class DefaultCommandContextFactory implements CommandContextFactory {

    @Override
    public CommandContext getCommandContext() {
        return new CommandContext();
    }
}
