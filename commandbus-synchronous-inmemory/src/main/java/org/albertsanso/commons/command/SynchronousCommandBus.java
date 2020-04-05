package org.albertsanso.commons.command;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@Named
public class SynchronousCommandBus implements CommandBus {
    private Map<String, DomainCommandHandler> registry;

    @Inject
    public SynchronousCommandBus(List<DomainCommandHandler<? extends DomainCommand>> handlerList) {
        registry =  new HashMap<>();
        if (!isNull(handlerList)) {
            handlerList.forEach(this::registerHandler);
        }
    }

    @Override
    public DomainCommandResponse push(DomainCommand command) {
        DomainCommandHandler handler = registry.get(command.getClass().getName());
        return executeInmediatily(command, handler);
    }

    @Override
    public void registerHandler(DomainCommandHandler handler) {
        if (registry.containsKey(handler.handles().getName())) {
            throw new IllegalStateException("Command registered yet!");
        }
        registry.put(handler.handles().getName(), handler);

    }

    private DomainCommandResponse executeInmediatily(DomainCommand command, DomainCommandHandler handler) {
        return handler.handle(command);
    }
}
