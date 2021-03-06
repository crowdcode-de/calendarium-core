package io.calendarium.core;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;

/**
 * A day -> events map. This type is merely a convenience to have a strong typed domain model.
 *
 * @since 1.0.0
 */
public class EventMap  extends TreeMap<LocalDate, List<CalendarEvent>> {

}
