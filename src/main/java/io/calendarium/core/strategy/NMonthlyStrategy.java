package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class NMonthlyStrategy implements DueDateStrategy {

    private final CalendarEvent event;

    protected NMonthlyStrategy(CalendarEvent event) {
        this.event = event;
    }

    @Override
    public boolean isDue(LocalDateTime dateTime) {
        final LocalDateTime dueDateTime = event.getDueDateTime();
        int everyNthMonth = getEveryNthMonth();

        return isNMonthDue(dateTime, dueDateTime, everyNthMonth, event.getRepeatUntil());
    }

    abstract int getEveryNthMonth();

    public static boolean isNMonthDue(LocalDateTime dateTime, LocalDateTime dueDateTime, int everyNthMonth, LocalDateTime repeatUntil) {
        if (dueDateTime.isAfter(repeatUntil) || dueDateTime.getDayOfMonth() != dateTime.getDayOfMonth()) {
            return false;
        }

        LocalDateTime calcDate = dueDateTime;

        while (calcDate.isBefore(dateTime) || calcDate.equals(dateTime)) {
            if (calcDate.isEqual(dateTime)) {
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
        final LocalDate localDate = event.getDueDateTime().toLocalDate();
        final int everyNthMonth = getEveryNthMonth();
        final LocalDateTime repeatUntil = event.getRepeatUntil();

        return isNMonthDue(date, localDate, everyNthMonth, repeatUntil);
    }

    public static boolean isNMonthDue(LocalDate date, LocalDate localDate, int everyNthMonth, LocalDateTime repeatUntil) {
        if (repeatUntil.toLocalDate().isBefore(date) || localDate.getDayOfMonth() != date.getDayOfMonth()) {
            return false;
        }

        LocalDate calcDate = localDate;

        while (calcDate.isBefore(date) || calcDate.equals(date)) {
            if (calcDate.isEqual(date)) {
                return true;
            }
            calcDate = calcDate.plus(everyNthMonth, ChronoUnit.MONTHS);
        }

        return false;
    }

}
