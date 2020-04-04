package org.albertsanso.commons.event;

import java.time.ZonedDateTime;

public class DomainEvent extends Event {
    public DomainEvent(ZonedDateTime occurredOn, String uuid) {
        super(occurredOn, uuid);
    }
}
