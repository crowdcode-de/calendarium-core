package io.calendarium.core.impl;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Singular event. This is a single event with no recurring
 */
public class SingularCalendarEventImpl extends CalendarEventImpl {


    /**
     * Constructor. All Recurring events are treated like value objects.
     *
     * @param uuid
     * @param precision   - the precision (date or date/time)
     * @param name        - the name of the event
     * @param description - a brief description
     * @param created     - creation timestamp
     * @param dueDateTime - due date
     */
    public SingularCalendarEventImpl(UUID uuid, Precision precision, String name, String description, LocalDateTime created, LocalDateTime dueDateTime) {
        super(uuid, precision, name, description, created, dueDateTime, dueDateTime, EventType.SINGULAR);
    }

    @Override
    public LocalDateTime getRepeatUntil() {
        return getDueDateTime();
    }
}
