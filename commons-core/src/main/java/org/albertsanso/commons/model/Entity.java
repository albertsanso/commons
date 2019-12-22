package org.albertsanso.commons.model;

import org.albertsanso.commons.event.Event;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Entity {
    private final List<@NotNull Event> events = new ArrayList();

    protected void publishEvent(Event event) {
        this.events.add(event);
    }

    public List<Event> getEvents() { return Collections.unmodifiableList(this.events); }

    public boolean hasEvents() { return !events.isEmpty(); }
}
