package io.calendarium.core;

import java.time.LocalDateTime;

public class HalfYearEvent extends NMonthlyEvent{
    public HalfYearEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, int dayOfMonth) {
        super(precision, name, description, created, dueDateTime, dayOfMonth, 6);
    }
}
