package io.calendarium.core.impl;

import java.time.LocalDateTime;
import java.util.UUID;

public class FourMonthlyEventImpl extends CalendarEventImpl {
    public FourMonthlyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(uuid, precision, name, description, created, dueDateTime, repeatUntil, EventType.FOUR_MONTHLY);
    }

    public FourMonthlyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(uuid, precision, name, description, created, dueDateTime, LocalDateTime.MAX, EventType.FOUR_MONTHLY);
    }
}
