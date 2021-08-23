package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Weekly event handling strategy
 *
 * @since 1.0.0
 */
public class WeeklyStrategy implements DueDateStrategy {

    private final CalendarEvent event;

    public WeeklyStrategy(CalendarEvent event) {
        this.event = event;
    }


    @Override
    public boolean isDue(LocalDateTime dateTime) {
        final LocalDateTime dueDateTime = event.getDueDateTime();
        final DayOfWeek dayOfWeek = dueDateTime.toLocalDate().getDayOfWeek();
        return isWeeklyDue(dateTime, dueDateTime, dayOfWeek);
    }

    public static boolean isWeeklyDue(LocalDateTime dateTime, LocalDateTime dueDateTime, DayOfWeek dayOfWeek) {
        return (dueDateTime.isBefore(dateTime) ||
                dueDateTime.equals(dateTime)) &&
                dateTime.getDayOfWeek().equals(dayOfWeek);
    }

    @Override
    public boolean isDue(LocalDate date) {
        final LocalDate dueDate = event.getDueDateTime().toLocalDate();
        final DayOfWeek dayOfWeek = date.getDayOfWeek();
        return isWeeklyDue(date, dueDate, dayOfWeek);
    }

    static boolean isWeeklyDue(LocalDate date, LocalDate dueDate, DayOfWeek dayOfWeek) {
        return (dueDate.isBefore(date) ||
                dueDate.equals(date)) &&
                date.getDayOfWeek().equals(dayOfWeek);
    }

}
