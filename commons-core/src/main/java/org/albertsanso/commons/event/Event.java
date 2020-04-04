package org.albertsanso.commons.event;

import java.time.ZonedDateTime;

public abstract class Event {
    private final ZonedDateTime occurredOn;
    private final String uuid;

    public Event(ZonedDateTime occurredOn, String uuid) {
        this.occurredOn = occurredOn;
        this.uuid = uuid;
    }

    public ZonedDateTime getOccurredOn() {
        return occurredOn;
    }

    public String getUuid() {
        return uuid;
    }
}
