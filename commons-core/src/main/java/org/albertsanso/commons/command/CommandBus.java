package org.albertsanso.commons.command;

public interface CommandBus {
    DomainCommandResponse push(DomainCommand command);
    void registerHandler(DomainCommandHandler handler);
}
