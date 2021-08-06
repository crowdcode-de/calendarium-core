package io.calendarium.core;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyEvent extends RecurringEvent{
    private final DayOfWeek dayOfWeek;

    public WeeklyEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, DayOfWeek dayOfWeek, LocalDateTime repeatUntil) {
        super(precision, name, description, created, dueDateTime, repeatUntil);
        this.dayOfWeek = dayOfWeek;
    }

    public WeeklyEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, DayOfWeek dayOfWeek) {
        super(precision, name, description, created, dueDateTime,  LocalDateTime.MAX);
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public boolean isDue(LocalDateTime dateTime) {
        final LocalDateTime dueDateTime = getDueDateTime();
        final DayOfWeek dayOfWeek = this.dayOfWeek;
        return isWeeklyDue(dateTime, dueDateTime, dayOfWeek);
    }

    public static boolean isWeeklyDue(LocalDateTime dateTime, LocalDateTime dueDateTime, DayOfWeek dayOfWeek) {
        return (dueDateTime.isBefore(dateTime) ||
                dueDateTime.equals(dateTime)) &&
                dateTime.getDayOfWeek().equals(dayOfWeek);
    }

    @Override
    public boolean isDue(LocalDate date) {
        final LocalDate dueDate = getDueDateTime().toLocalDate();
        final DayOfWeek dayOfWeek = this.dayOfWeek;
        return isWeeklyDue(date, dueDate, dayOfWeek);
    }

    public static boolean isWeeklyDue(LocalDate date, LocalDate dueDate, DayOfWeek dayOfWeek) {
        return (dueDate.isBefore(date) ||
                dueDate.equals(date)) &&
                date.getDayOfWeek().equals(dayOfWeek);
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
