package io.calendarium.core.impl;

import java.time.LocalDateTime;
import java.util.UUID;

public class HalfYearEventImpl extends CalendarEventImpl {
    public HalfYearEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(uuid, precision, name, description, created, dueDateTime, repeatUntil, EventType.HALF_YEARLY);
    }

    public HalfYearEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(uuid, precision, name, description, created, dueDateTime, LocalDateTime.MAX, EventType.HALF_YEARLY);
    }
}
