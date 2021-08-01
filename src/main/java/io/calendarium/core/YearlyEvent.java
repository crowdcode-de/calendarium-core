package io.calendarium.core;

import java.time.LocalDateTime;

public class YearlyEvent extends NMonthlyEvent{
    public YearlyEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, LocalDateTime repeatUntil) {
        super(precision, name, description, created, dueDateTime,  12, repeatUntil);
    }
    public YearlyEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(precision, name, description, created, dueDateTime,  12, LocalDateTime.MAX);
    }
}
