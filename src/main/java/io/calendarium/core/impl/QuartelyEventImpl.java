package io.calendarium.core.impl;

import io.calendarium.core.QuartelyEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class QuartelyEventImpl extends NMonthlyEventImpl implements QuartelyEvent {
    public QuartelyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(uuid, precision, name, description, created, dueDateTime, 3, repeatUntil);
    }

    public QuartelyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(uuid, precision, name, description, created, dueDateTime, 3, LocalDateTime.MAX);
    }
}
