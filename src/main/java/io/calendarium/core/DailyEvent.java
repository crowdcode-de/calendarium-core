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
        return (getDueDateTime().isBefore(dateTime) || getDueDateTime().equals(dateTime)) && dateTime.isBefore(getRepeatUntil());
    }

    @Override
    public boolean isDue(LocalDate date) {
        return (getDueDateTime().toLocalDate().isBefore(date) || getDueDateTime().toLocalDate().equals(date)) && date.isBefore(getRepeatUntil().toLocalDate());
    }
}
