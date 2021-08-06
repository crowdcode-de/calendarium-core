package io.calendarium.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyEvent extends RecurringEvent {

    public DailyEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(precision, name, description, created, dueDateTime, repeatUntil);
    }

    public DailyEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(precision, name, description, created, dueDateTime, LocalDateTime.MAX);
    }

    @Override
    public boolean isDue(LocalDateTime dateTime) {
        final LocalDateTime dueDateTime = getDueDateTime();
        final LocalDateTime repeatUntil = getRepeatUntil();
        return isDailyDue(dateTime, dueDateTime, repeatUntil);
    }

    public static boolean isDailyDue(LocalDateTime dateTime, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        return (dueDateTime.isBefore(dateTime) || dueDateTime.equals(dateTime)) && dateTime.isBefore(repeatUntil);
    }

    @Override
    public boolean isDue(LocalDate date) {
        final LocalDate dueDate = getDueDateTime().toLocalDate();
        final LocalDateTime repeatUntil = getRepeatUntil();
        return isDailyDue(date, dueDate, repeatUntil);
    }

    public static boolean isDailyDue(LocalDate date, LocalDate dueDate, LocalDateTime repeatUntil) {
        return (dueDate.isBefore(date) || dueDate.equals(date)) && date.isBefore(repeatUntil.toLocalDate());
    }
}
