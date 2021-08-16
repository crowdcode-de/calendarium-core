package io.calendarium.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Singular event interface. This is a single event with no recurring
 */
public interface SingularCalendarEvent extends CalendarEvent {

    @Override
    default boolean isDue(LocalDateTime dateTime) {
        return isDue(getDueDateTime(), dateTime, getPrecision());
    }

    @Override
    default boolean isDue(LocalDate date) {
        return isDue(getDueDateTime().toLocalDate(), date, getPrecision());
    }

    @Override
    Precision getPrecision();

    @Override
    String getName();

    @Override
    String getDescription();

    @Override
    LocalDateTime getCreated();

    LocalDateTime getDueDateTime();
}
