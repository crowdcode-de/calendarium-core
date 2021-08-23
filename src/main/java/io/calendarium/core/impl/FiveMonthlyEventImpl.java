package io.calendarium.core.impl;

import java.time.LocalDateTime;
import java.util.UUID;

public class FiveMonthlyEventImpl extends CalendarEventImpl {
    public FiveMonthlyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(uuid, precision, name, description, created, dueDateTime, repeatUntil, EventType.FIVE_MONTHLY);
    }

    public FiveMonthlyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(uuid, precision, name, description, created, dueDateTime, LocalDateTime.MAX, EventType.FIVE_MONTHLY);
    }
}
