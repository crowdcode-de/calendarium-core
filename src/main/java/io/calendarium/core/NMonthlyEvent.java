package io.calendarium.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

public class NMonthlyEvent extends RecurringEvent{

    private final int dayOfMonth;
    private final int everyNthMonth;

    public NMonthlyEvent(Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime, int dayOfMonth, int everyNthMonth) {
        super(precision, name, description, created, dueDateTime);
        this.dayOfMonth = dayOfMonth;
        this.everyNthMonth = everyNthMonth;
    }

    @Override
    public boolean isDue(LocalDateTime dateTime) {
        final LocalDateTime dueDateTime = getDueDateTime();

        if (dueDateTime.getDayOfMonth() != dateTime.getDayOfMonth()) {
            return false;
        }

        LocalDateTime calcDate = dueDateTime;

        while (calcDate.isBefore(calcDate)|| calcDate.equals(calcDate)) {
            if (calcDate.isEqual(calcDate)){
                return true;
            }
            calcDate = calcDate.plus(everyNthMonth, ChronoUnit.MONTHS);
        }

        return false;
    }


    /**
     *
     * checks whether a nmonthly recurrence is due
     *
     * @param date - the date to check
     * @return true, if a nmonthly occurrence is due
     *
     * Example
     *
     * - from 24.07.2021, a 2-month due item is created
     * - this means, that isDue will return true on 24.07.2021, 24.09.2021, 24.11.2021, 24.01.2021
     * - this means, 24.05.2021 will return false.
     *
     * the due date is also a start date WHEN to start evaluating
     *
     */
    @Override
    public boolean isDue(LocalDate date) {
        final LocalDate localDate = getDueDateTime().toLocalDate();

        if (localDate.getDayOfMonth() != date.getDayOfMonth()) {
            return false;
        }

        LocalDate calcDate = localDate;

        while (calcDate.isBefore(date)|| calcDate.equals(date)) {
            if (calcDate.isEqual(date)){
                return true;
            }
            calcDate = calcDate.plus(everyNthMonth, ChronoUnit.MONTHS);
        }

        return false;
    }

}
