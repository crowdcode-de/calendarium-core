package io.calendarium.core.impl;

import java.time.LocalDateTime;
import java.util.UUID;

public class QuartelyEventImpl extends CalendarEventImpl {
    public QuartelyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(uuid, precision, name, description, created, dueDateTime, repeatUntil, EventType.QUARTERLY);
    }

    public QuartelyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(uuid, precision, name, description, created, dueDateTime, LocalDateTime.MAX, EventType.QUARTERLY);
    }
}
