package io.calendarium.core.impl;

import io.calendarium.core.DailyEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class DailyEventImpl extends RecurringEventImpl implements DailyEvent {

    public DailyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(uuid, precision, name, description, created, dueDateTime, repeatUntil);
    }

    public DailyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(uuid, precision, name, description, created, dueDateTime, LocalDateTime.MAX);
    }

}
