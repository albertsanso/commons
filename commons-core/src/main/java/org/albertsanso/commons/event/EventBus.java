package org.albertsanso.commons.event;

public interface EventBus {
    void publish(DomainEvent domainEvent);
    void registerSubscriber(DomainEventSubscriber handler);
}
