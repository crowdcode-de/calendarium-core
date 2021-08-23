package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Singular event interface. This is a single event with no recurring
 */
public class SingularStrategy implements DueDateStrategy {

    private final CalendarEvent event;

    public SingularStrategy(CalendarEvent event) {
        this.event = event;
    }

    @Override
    public boolean isDue(LocalDateTime dateTime) {
        return isDue(event.getDueDateTime(), dateTime, event.getPrecision());
    }

    @Override
    public boolean isDue(LocalDate date) {
        return isDue(event.getDueDateTime(), date.atTime(0, 0, 0), event.getPrecision());
    }

    public boolean isDue(LocalDateTime dueDateTime, LocalDateTime dateTime, CalendarEvent.Precision precision) {
        switch (precision) {
            case DATE:
                return dueDateTime.toLocalDate().equals(dateTime.toLocalDate());
            case TIME:
                return dueDateTime.equals(dateTime);
        }
        return false;
    }

}
