package io.calendarium.core;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Weekly event interface
 */
public interface WeeklyEvent extends RecurringEvent{


    @Override
    default boolean isDue(LocalDateTime dateTime) {
        final LocalDateTime dueDateTime = getDueDateTime();
        final DayOfWeek dayOfWeek = getDayOfWeek();
        return isWeeklyDue(dateTime, dueDateTime, dayOfWeek);
    }

    static boolean isWeeklyDue(LocalDateTime dateTime, LocalDateTime dueDateTime, DayOfWeek dayOfWeek) {
        return (dueDateTime.isBefore(dateTime) ||
                dueDateTime.equals(dateTime)) &&
                dateTime.getDayOfWeek().equals(dayOfWeek);
    }

    @Override
    default boolean isDue(LocalDate date) {
        final LocalDate dueDate = getDueDateTime().toLocalDate();
        final DayOfWeek dayOfWeek = getDayOfWeek();
        return isWeeklyDue(date, dueDate, dayOfWeek);
    }

    static boolean isWeeklyDue(LocalDate date, LocalDate dueDate, DayOfWeek dayOfWeek) {
        return (dueDate.isBefore(date) ||
                dueDate.equals(date)) &&
                date.getDayOfWeek().equals(dayOfWeek);
    }

    DayOfWeek getDayOfWeek();
}
