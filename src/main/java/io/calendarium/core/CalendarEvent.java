package io.calendarium.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Base interface describing an event.
 *
 * An implementation both must be capable of checking against raw dates (calendar) or against time (schedule)
 * Therefore you should be able to set the precision
 *
 */
public interface CalendarEvent {

    enum Precision {
        DATE,
        TIME
    }

    /**
     * This method is used for second-wise precision checks
     *
     * @param dateTime - the date time to check for
     * @return true, if an event implementation is due to a certain date/time
     */
    boolean isDue(LocalDateTime dateTime);

    /**
     * this method is used for date-precision checks
     *
     * @param date - the date to check
     * @return true, if an implementing event is due on a certain date
     */
    boolean isDue(LocalDate date);

    /**
     * @return the selected Precision
     */
    Precision getPrecision();

    /**
     * @return the name
     */
    String getName();

    /**
     * @return the description
     */
    String getDescription();

    /**
     * @return the creation date of the object
     */
    LocalDateTime getCreated();

    /**
     * @param dueDate - the due date we like to check
     * @param referenceDate- the reference date to be checked
     * @param precision - the precision
     * @return true, if the dueDate has been superceded
     */
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


    /**
     * Convenience method with LocalDate instead of LocalDateTime. See isDue(LocalDateTime) for details.
     * @param dueDate
     * @param referenceDate
     * @param precision
     * @return
     */
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
