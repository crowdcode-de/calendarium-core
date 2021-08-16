package io.calendarium.core.impl;

import io.calendarium.core.HalfYearEvent;

import java.time.LocalDateTime;

public class HalfYearEventImpl extends NMonthlyEventImpl implements HalfYearEvent {
    public HalfYearEventImpl(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(precision, name, description, created, dueDateTime, 6, repeatUntil);
    }
    public HalfYearEventImpl(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(precision, name, description, created, dueDateTime, 6, LocalDateTime.MAX);
    }
}
