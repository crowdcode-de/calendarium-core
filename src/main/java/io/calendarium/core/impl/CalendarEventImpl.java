package io.calendarium.core.impl;

import io.calendarium.core.CalendarEvent;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base class of recurring events. A recurring event will recur until the repeatUntil date has been reached
 */
public abstract class CalendarEventImpl implements CalendarEvent {


    /**
     * Constructor. All Recurring events are treated like value objects.
     *
     * @param uuid
     * @param precision   - the precision (date or date/time)
     * @param name        - the name of the event
     * @param description - a brief description
     * @param created     - creation timestamp
     * @param dueDateTime - due date
     * @param repeatUntil - do not recur this event after repeatUntil date(time)
     * @param eventType
     */
    public CalendarEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil, EventType eventType) {
        this.uuid = uuid;
        this.precision = precision;
        this.name = name;
        this.description = description;
        this.created = created;
        this.dueDateTime = dueDateTime;
        this.repeatUntil = repeatUntil;
        this.eventType = eventType;
    }

    private final UUID uuid;
    private final Precision precision;
    private final String name;
    private final String description;
    private final LocalDateTime created;
    private final LocalDateTime dueDateTime;
    private final LocalDateTime repeatUntil;
    private final EventType eventType;


    @Override
    public Precision getPrecision() {
        return precision;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public LocalDateTime getRepeatUntil() {
        return repeatUntil;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public EventType getEventType() {
        return eventType;
    }
}
