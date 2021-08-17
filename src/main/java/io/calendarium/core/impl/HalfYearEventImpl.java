package io.calendarium.core.impl;

import io.calendarium.core.HalfYearEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class HalfYearEventImpl extends NMonthlyEventImpl implements HalfYearEvent {
    public HalfYearEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(uuid, precision, name, description, created, dueDateTime, 6, repeatUntil);
    }
    public HalfYearEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(uuid, precision, name, description, created, dueDateTime, 6, LocalDateTime.MAX);
    }
}
