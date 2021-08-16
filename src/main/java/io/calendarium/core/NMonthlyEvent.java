package io.calendarium.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public interface NMonthlyEvent extends RecurringEvent{

    @Override
    default boolean isDue(LocalDateTime dateTime) {
        final LocalDateTime dueDateTime = getDueDateTime();
        int everyNthMonth = getEveryNthMonth();

        return isNMonthDue(dateTime, dueDateTime, everyNthMonth, getRepeatUntil());
    }

    int getEveryNthMonth();

    static boolean isNMonthDue(LocalDateTime dateTime, LocalDateTime dueDateTime, int everyNthMonth, LocalDateTime repeatUntil) {
        if (dueDateTime.isAfter(repeatUntil) || dueDateTime.getDayOfMonth() != dateTime.getDayOfMonth()) {
            return false;
        }

        LocalDateTime calcDate = dueDateTime;

        while (calcDate.isBefore(dateTime)|| calcDate.equals(dateTime)) {
            if (calcDate.isEqual(dateTime)){
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
    default boolean isDue(LocalDate date) {
        final LocalDate localDate = getDueDateTime().toLocalDate();
        final int everyNthMonth = getEveryNthMonth();
        final LocalDateTime repeatUntil = getRepeatUntil();

        return isNMonthDue(date, localDate, everyNthMonth, repeatUntil);
    }

    static boolean isNMonthDue(LocalDate date, LocalDate localDate, int everyNthMonth, LocalDateTime repeatUntil) {
        if (repeatUntil.toLocalDate().isBefore(date) || localDate.getDayOfMonth() != date.getDayOfMonth()) {
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
