package io.calendarium.core.impl;

import io.calendarium.core.NMonthlyEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class NMonthlyEventImpl extends RecurringEventImpl implements NMonthlyEvent {

    private final int everyNthMonth;

    public NMonthlyEventImpl(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, int everyNthMonth, LocalDateTime repeatUntil) {
        super(precision, name, description, created, dueDateTime, repeatUntil);
        this.everyNthMonth = everyNthMonth;
    }

    public NMonthlyEventImpl(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, int everyNthMonth) {
        super(precision, name, description, created, dueDateTime, LocalDateTime.MAX);
        this.everyNthMonth = everyNthMonth;
    }

    @Override
    public int getEveryNthMonth() {
        return everyNthMonth;
    }


}
