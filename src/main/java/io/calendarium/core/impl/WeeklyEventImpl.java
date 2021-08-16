package io.calendarium.core.impl;

import io.calendarium.core.WeeklyEvent;
import io.calendarium.core.impl.RecurringEventImpl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyEventImpl extends RecurringEventImpl implements WeeklyEvent {
    private final DayOfWeek dayOfWeek;

    public WeeklyEventImpl(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, DayOfWeek dayOfWeek, LocalDateTime repeatUntil) {
        super(precision, name, description, created, dueDateTime, repeatUntil);
        this.dayOfWeek = dayOfWeek;
    }

    public WeeklyEventImpl(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, DayOfWeek dayOfWeek) {
        super(precision, name, description, created, dueDateTime,  LocalDateTime.MAX);
        this.dayOfWeek = dayOfWeek;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
