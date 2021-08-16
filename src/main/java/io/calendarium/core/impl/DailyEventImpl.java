package io.calendarium.core.impl;

import io.calendarium.core.DailyEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyEventImpl extends RecurringEventImpl implements DailyEvent {

    public DailyEventImpl(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(precision, name, description, created, dueDateTime, repeatUntil);
    }

    public DailyEventImpl(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(precision, name, description, created, dueDateTime, LocalDateTime.MAX);
    }

}
