package io.calendarium.core.impl;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.UUID;

public class WeeklyEventImpl extends CalendarEventImpl {

    public WeeklyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, DayOfWeek dayOfWeek, LocalDateTime repeatUntil) {
        super(uuid, precision, name, description, created, dueDateTime, repeatUntil, EventType.WEEKLY);
    }

    public WeeklyEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, DayOfWeek dayOfWeek) {
        super(uuid, precision, name, description, created, dueDateTime, LocalDateTime.MAX, EventType.WEEKLY);
    }

}
