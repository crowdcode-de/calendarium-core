package io.calendarium.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * A daily event interface
 */
public interface DailyEvent extends RecurringEvent {


    @Override
    default boolean isDue(LocalDateTime dateTime) {
        final LocalDateTime dueDateTime = getDueDateTime();
        final LocalDateTime repeatUntil = getRepeatUntil();
        return isDailyDue(dateTime, dueDateTime, repeatUntil);
    }

    static boolean isDailyDue(LocalDateTime dateTime, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        return (dueDateTime.isBefore(dateTime) || dueDateTime.equals(dateTime)) && dateTime.isBefore(repeatUntil);
    }

    @Override
    default boolean isDue(LocalDate date) {
        final LocalDate dueDate = getDueDateTime().toLocalDate();
        final LocalDateTime repeatUntil = getRepeatUntil();
        return isDailyDue(date, dueDate, repeatUntil);
    }

    static boolean isDailyDue(LocalDate date, LocalDate dueDate, LocalDateTime repeatUntil) {
        return (dueDate.isBefore(date) || dueDate.equals(date)) && date.isBefore(repeatUntil.toLocalDate());
    }
}
