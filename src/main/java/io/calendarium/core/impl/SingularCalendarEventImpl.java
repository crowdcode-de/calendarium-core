package io.calendarium.core.impl;

import io.calendarium.core.SingularCalendarEvent;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Singular event. This is a single event with no recurring
 */
public class SingularCalendarEventImpl implements SingularCalendarEvent {

    /**
     * Constructor
     *
     * @param uuid
     * @param precision - the precision (date or date/time)
     * @param name - the name of the
     * @param description - a brief description of the event
     * @param created - a creation timestamp
     * @param dueDateTime -  due date
     */
    public SingularCalendarEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        this.uuid = uuid;
        this.precision = precision;
        this.name = name;
        this.description = description;
        this.created = created;
        this.dueDateTime = dueDateTime;
    }

    private final UUID uuid;
    private final Precision precision;
    private final String name;
    private final String description;
    private final LocalDateTime created;
    private final LocalDateTime dueDateTime;

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

    @Override
    public UUID getUuid() {
        return uuid;
    }
}
