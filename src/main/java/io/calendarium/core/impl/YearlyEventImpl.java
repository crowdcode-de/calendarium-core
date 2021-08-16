package io.calendarium.core.impl;

import io.calendarium.core.NMonthlyEvent;

import java.time.LocalDateTime;

public class YearlyEventImpl extends NMonthlyEventImpl implements NMonthlyEvent {
    public YearlyEventImpl(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(precision, name, description, created, dueDateTime,  12, repeatUntil);
    }
    public YearlyEventImpl(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(precision, name, description, created, dueDateTime,  12, LocalDateTime.MAX);
    }
}
