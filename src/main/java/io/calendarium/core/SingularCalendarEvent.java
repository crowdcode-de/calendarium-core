package io.calendarium.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Singular event. This is a single event with no recurring
 */
public class SingularCalendarEvent implements CalendarEvent {

    /**
     * Constructor
     *
     * @param precision - the precision (date or date/time)
     * @param name - the name of the
     * @param description - a brief description of the event
     * @param created - a creation timestamp
     * @param dueDateTime -  due date
     */
    public SingularCalendarEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        this.precision = precision;
        this.name = name;
        this.description = description;
        this.created = created;
        this.dueDateTime = dueDateTime;
    }

    private final Precision precision;
    private final String name;
    private final String description;
    private final LocalDateTime created;
    private final LocalDateTime dueDateTime;

    @Override
    public boolean isDue(LocalDateTime dateTime) {
        return isDue(dueDateTime, dateTime, precision);
    }

    @Override
    public boolean isDue(LocalDate date) {
        return isDue(dueDateTime.toLocalDate(), date, precision);
    }

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
}
