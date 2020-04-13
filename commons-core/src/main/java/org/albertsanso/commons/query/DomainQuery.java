package org.albertsanso.commons.query;

import java.time.ZonedDateTime;

public abstract class DomainQuery {
    private final ZonedDateTime occurredOn;
    private final String uuid;

    protected DomainQuery(ZonedDateTime occurredOn, String uuid) {
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
