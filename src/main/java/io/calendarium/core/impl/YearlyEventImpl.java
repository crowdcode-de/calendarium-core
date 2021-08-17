package io.calendarium.core.impl;

import io.calendarium.core.NMonthlyEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class YearlyEventImpl extends NMonthlyEventImpl implements NMonthlyEvent {
    public YearlyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(uuid, precision, name, description, created, dueDateTime,  12, repeatUntil);
    }
    public YearlyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(uuid, precision, name, description, created, dueDateTime,  12, LocalDateTime.MAX);
    }
}
