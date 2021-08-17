package io.calendarium.core.impl;

import io.calendarium.core.WeeklyEvent;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.UUID;

public class WeeklyEventImpl extends RecurringEventImpl implements WeeklyEvent {
    private final DayOfWeek dayOfWeek;

    public WeeklyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, DayOfWeek dayOfWeek, LocalDateTime repeatUntil) {
        super(uuid, precision, name, description, created, dueDateTime, repeatUntil);
        this.dayOfWeek = dayOfWeek;
    }

    public WeeklyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, DayOfWeek dayOfWeek) {
        super(uuid, precision, name, description, created, dueDateTime,  LocalDateTime.MAX);
        this.dayOfWeek = dayOfWeek;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
