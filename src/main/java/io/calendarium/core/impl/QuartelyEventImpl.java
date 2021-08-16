package io.calendarium.core.impl;

import io.calendarium.core.QuartelyEvent;

import java.time.LocalDateTime;

public class QuartelyEventImpl extends NMonthlyEventImpl implements QuartelyEvent {
    public QuartelyEventImpl(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(precision, name, description, created, dueDateTime, 3, repeatUntil);
    }

    public QuartelyEventImpl(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(precision, name, description, created, dueDateTime, 3, LocalDateTime.MAX);
    }
}
