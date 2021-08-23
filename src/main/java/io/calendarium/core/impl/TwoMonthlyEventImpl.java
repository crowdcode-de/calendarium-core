package io.calendarium.core.impl;

import java.time.LocalDateTime;
import java.util.UUID;

public class TwoMonthlyEventImpl extends CalendarEventImpl {
    public TwoMonthlyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(uuid, precision, name, description, created, dueDateTime, repeatUntil, EventType.TWO_MONTHLY);
    }

    public TwoMonthlyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(uuid, precision, name, description, created, dueDateTime, LocalDateTime.MAX, EventType.TWO_MONTHLY);
    }
}
