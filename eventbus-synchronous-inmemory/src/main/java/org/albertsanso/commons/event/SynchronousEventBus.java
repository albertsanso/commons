package org.albertsanso.commons.event;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.isNull;

@Named
public class SynchronousEventBus implements EventBus {

    private Map<String, DomainEventSubscriber> registry;

    @Inject
    public SynchronousEventBus(List<DomainEventSubscriber<? extends DomainEvent>> subscriberList) {
        this.registry = new HashMap<>();
        if (!isNull(subscriberList)) {
            subscriberList.forEach(this::registerSubscriber);
        }
    }

    @Override
    public void publish(DomainEvent domainEvent) {
        DomainEventSubscriber subscriber = registry.get(domainEvent.getClass().getName());
        if (!Objects.isNull(subscriber)) {
            executeInmediatily(domainEvent, subscriber);
        }
    }

    @Override
    public void registerSubscriber(DomainEventSubscriber handler) {
        if (registry.containsKey(handler.handles().getName())) {
            throw new IllegalStateException("Event registered yet!");
        }
        registry.put(handler.handles().getName(), handler);
    }

    private void executeInmediatily(DomainEvent domainEvent, DomainEventSubscriber domainEventSubscriber) {
        domainEventSubscriber.handle(domainEvent);
    }
}
