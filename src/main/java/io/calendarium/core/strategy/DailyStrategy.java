package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * A daily event interface
 */
public class DailyStrategy implements DueDateStrategy {

    private final CalendarEvent event;

    public DailyStrategy(CalendarEvent event) {
        this.event = event;
    }

    @Override
    public boolean isDue(LocalDateTime dateTime) {
        final LocalDateTime dueDateTime = event.getDueDateTime();
        final LocalDateTime repeatUntil = event.getRepeatUntil();
        return isDailyDue(dateTime, dueDateTime, repeatUntil);
    }

    public static boolean isDailyDue(LocalDateTime dateTime, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        return (dueDateTime.isBefore(dateTime) || dueDateTime.equals(dateTime)) && dateTime.isBefore(repeatUntil);
    }

    @Override
    public boolean isDue(LocalDate date) {
        final LocalDate dueDate = event.getDueDateTime().toLocalDate();
        final LocalDateTime repeatUntil = event.getRepeatUntil();
        return isDailyDue(date, dueDate, repeatUntil);
    }

    static boolean isDailyDue(LocalDate date, LocalDate dueDate, LocalDateTime repeatUntil) {
        return (dueDate.isBefore(date) || dueDate.equals(date)) && date.isBefore(repeatUntil.toLocalDate());
    }
}
