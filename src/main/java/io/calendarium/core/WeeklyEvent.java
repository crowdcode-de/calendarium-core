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
        return (getDueDateTime().isBefore(dateTime) ||
                getDueDateTime().equals(dateTime)) &&
                dateTime.getDayOfWeek().equals(dayOfWeek);
    }

    @Override
    public boolean isDue(LocalDate date) {
        return (getDueDateTime().toLocalDate().isBefore(date) ||
                getDueDateTime().toLocalDate().equals(date)) &&
                date.getDayOfWeek().equals(dayOfWeek);
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
