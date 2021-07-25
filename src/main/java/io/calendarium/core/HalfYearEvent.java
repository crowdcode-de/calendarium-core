package io.calendarium.core;

import java.time.LocalDateTime;

public class HalfYearEvent extends NMonthlyEvent{
    public HalfYearEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(precision, name, description, created, dueDateTime, 6);
    }
}
