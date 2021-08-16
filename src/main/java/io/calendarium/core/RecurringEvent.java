package io.calendarium.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Base interface of recurring events. A recurring event will recur until the repeatUntil date has been reached
 */
public interface RecurringEvent extends CalendarEvent{

    @Override
    boolean isDue(LocalDateTime dateTime);

    @Override
    boolean  isDue(LocalDate date) ;

    @Override
    Precision getPrecision();

    @Override
    String getName();

    @Override
    String getDescription();

    @Override
    LocalDateTime getCreated();

    LocalDateTime getDueDateTime();

    LocalDateTime getRepeatUntil();
}
