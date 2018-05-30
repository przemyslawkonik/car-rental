package pl.edu.wszib.command.dispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.command.CommandExecutor;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@Service
public class DynamicCommandDispatcher extends DefaultCommandDispatcher {

    @Autowired
    private Map<String, CommandExecutor> rawExecutorMap;

    @PostConstruct
    public void prepareExecutorsMap() {
        Map<Class, CommandExecutor> executorMap = new HashMap<>();
        for (CommandExecutor executor : rawExecutorMap.values()) {
            Type type = ((ParameterizedType) executor.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
            executorMap.put((Class) type, executor);
        }
        this.executorMap = executorMap;
    }
}
