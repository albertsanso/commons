package org.albertsanso.commons.event;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

import static java.util.Objects.isNull;

@Named
public class SynchronousEventBus implements EventBus {

    private Map<String, List<DomainEventSubscriber>> registry;

    @Inject
    public SynchronousEventBus(List<DomainEventSubscriber<? extends DomainEvent>> subscriberList) {
        this.registry = new HashMap<>();
        if (!isNull(subscriberList)) {
            subscriberList.forEach(this::registerSubscriber);
        }
    }

    @Override
    public void publish(DomainEvent domainEvent) {
        if (registry.containsKey(domainEvent.getClass().getName())) {
            List<DomainEventSubscriber> subscriberList = registry.get(domainEvent.getClass().getName());
            for (DomainEventSubscriber subscriber : subscriberList) {
                if (!Objects.isNull(subscriber)) {
                    executeInmediatily(domainEvent, subscriber);
                }
            }
        }
    }

    @Override
    public void registerSubscriber(DomainEventSubscriber handler) {
        List<DomainEventSubscriber> domainEventSubscribers;

        if (registry.containsKey(handler.handles().getName())) {
            domainEventSubscribers = registry.get(handler.handles().getName());
        }
        else {
            domainEventSubscribers = new ArrayList<>();
            registry.put(handler.handles().getName(), domainEventSubscribers);
        }
        domainEventSubscribers.add(handler);
    }

    private void executeInmediatily(DomainEvent domainEvent, DomainEventSubscriber domainEventSubscriber) {
        domainEventSubscriber.handle(domainEvent);
    }
}
