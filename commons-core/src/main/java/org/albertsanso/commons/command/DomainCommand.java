package org.albertsanso.commons.command;

import java.time.ZonedDateTime;
import java.util.Map;

public abstract class DomainCommand {
    private final ZonedDateTime occurredOn;
    private final String uuid;

    protected DomainCommand(ZonedDateTime occurredOn, String uuid) {
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
