package io.calendarium.core;

import io.calendarium.core.strategy.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base interface describing an event.
 * <p>
 * An implementation both must be capable of checking against raw dates (calendar) or against time (schedule)
 * Therefore you should be able to set the precision
 *
 * @since 1.0.0
 */
public interface CalendarEvent {

    UUID getUuid();

    enum Precision {
        DATE,
        TIME
    }

    enum EventType {
        SINGULAR,
        DAILY,
        WEEKLY,
        MONTHLY,
        TWO_MONTHLY,
        QUARTERLY,
        FOUR_MONTHLY,
        FIVE_MONTHLY,
        HALF_YEARLY,
        YEARLY
    }


    EventType getEventType();

    /**
     * This method is used for second-wise precision checks
     *
     * @param dateTime - the date time to check for
     * @return true, if an event implementation is due to a certain date/time
     */
    default boolean isDue(LocalDateTime dateTime) {
        final DueDateStrategy dueDateStrategy;
        final EventType eventType = getEventType();
        switch (eventType) {
            case SINGULAR:
                dueDateStrategy = new SingularStrategy(this);
                break;
            case DAILY:
                dueDateStrategy = new DailyStrategy(this);
                break;
            case WEEKLY:
                dueDateStrategy = new WeeklyStrategy(this);
                break;
            case MONTHLY:
                dueDateStrategy = new MonthlyStrategy(this);
                break;
            case TWO_MONTHLY:
                dueDateStrategy = new TwoMonthlyStrategy(this);
                break;
            case QUARTERLY:
                dueDateStrategy = new QuartelyStrategy(this);
                break;
            case FOUR_MONTHLY:
                dueDateStrategy = new FourMonthlyStrategy(this);
                break;
            case FIVE_MONTHLY:
                dueDateStrategy = new FiveMonthlyStrategy(this);
                break;
            case HALF_YEARLY:
                dueDateStrategy = new HalfYearStrategy(this);
                break;
            case YEARLY:
                dueDateStrategy = new YearlyStrategy(this);
                break;
            default:
                throw new IllegalArgumentException(eventType.name() + " is a type with no strategy mapped to it");
        }
        return dueDateStrategy.isDue(dateTime);
    }

    ;

    /**
     * this method is used for date-precision checks
     *
     * @param date - the date to check
     * @return true, if an implementing event is due on a certain date
     */
    default boolean isDue(LocalDate date) {
        return isDue(date.atTime(0, 0, 0));
    }

    ;

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
     * @return the due date time.
     */
    LocalDateTime getDueDateTime();

    /**
     * @return the repeating datetime. a singular event should set this equals to the due date time (@see {@link io.calendarium.core.impl.SingularCalendarEventImpl})
     */
    LocalDateTime getRepeatUntil();

}
