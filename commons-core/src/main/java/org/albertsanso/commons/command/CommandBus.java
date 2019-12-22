package org.albertsanso.commons.command;

public interface CommandBus {
    DomainCommandResponse publish(DomainCommand command);
    void registerHandler(DomainCommandHandler handler);
}
