package io.calendarium.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface CalendarEvent {

    enum Precision {
        DATE,
        TIME
    }

    boolean isDue(LocalDateTime dateTime);
    boolean isDue(LocalDate date);

    Precision getPrecision();

    String getName();
    String getDescription();

    LocalDateTime getCreated();

    default boolean isDue(LocalDateTime dueDate, LocalDateTime referenceDate, Precision precision){
        switch (precision){
            case DATE:
                return dueDate.isAfter(referenceDate) || dueDate.isEqual(referenceDate);
            case TIME:
                return dueDate.toLocalDate().isAfter(referenceDate.toLocalDate())
                        ||  dueDate.toLocalDate().isEqual(referenceDate.toLocalDate());
            default:
                return false;
        }
    }


    default boolean isDue(LocalDate dueDate, LocalDate referenceDate, Precision precision){
        switch (precision){
            case DATE:
            case TIME:
                return dueDate.isAfter(referenceDate) || dueDate.isEqual(referenceDate);
            default:
                return false;
        }
    }
}
