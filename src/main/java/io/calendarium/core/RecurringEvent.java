package io.calendarium.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Base class of recurring events. A recurring event will recur until the repeatUntil date has been reached
 */
public abstract class RecurringEvent implements CalendarEvent{


    /**
     * Constructor. All Recurring events are treated like value objects.
     *  @param precision - the precision (date or date/time)
     * @param name - the name of the event
     * @param description - a brief description
     * @param created - creation timestamp
     * @param dueDateTime - due date
     * @param repeatUntil - do not recur this event after repeatUntil date(time)
     */
    public RecurringEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        this.precision = precision;
        this.name = name;
        this.description = description;
        this.created = created;
        this.dueDateTime = dueDateTime;
        this.repeatUntil = repeatUntil;
    }

    private final Precision precision;
    private final String name;
    private final String description;
    private final LocalDateTime created;
    private final LocalDateTime dueDateTime;
    private final LocalDateTime repeatUntil;


    @Override
    public abstract boolean isDue(LocalDateTime dateTime);

    @Override
    public abstract boolean  isDue(LocalDate date) ;

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
}
