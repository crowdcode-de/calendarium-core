package io.calendarium.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class RecurringEvent implements CalendarEvent{


    public RecurringEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
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
}
