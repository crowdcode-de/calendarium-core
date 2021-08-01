package io.calendarium.core;

import java.time.LocalDateTime;

public class QuartelyEvent extends NMonthlyEvent{
    public QuartelyEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(precision, name, description, created, dueDateTime, 3, repeatUntil);
    }

    public QuartelyEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(precision, name, description, created, dueDateTime, 3, LocalDateTime.MAX);
    }
}
