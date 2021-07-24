package io.calendarium.core;

import java.time.LocalDateTime;

public class YearlyEvent extends NMonthlyEvent{
    public YearlyEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, int dayOfMonth) {
        super(precision, name, description, created, dueDateTime, dayOfMonth, 12);
    }
}
