package io.calendarium.core;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Calendarium class
 *
 * This class is used to create maps with dates. You can hand over a list of events and it will create a schedule of all
 * recurring events.
 *
 * Notice, recurring events are started once due. This means setting a weekly event at 01/01/2021 will start recurring
 * after 01/01/2021 weekly.
 *
 * @since 1.0.0
 */
public class Calendarium extends GregorianCalendar {

    private final List<CalendarEvent> calendarEvents;

    /**
     * constructor to ramp up a calendarium
     *
     * @param calendarEvents - the list of recurring and singular events
     */
    public Calendarium(List<CalendarEvent> calendarEvents) {
        this.calendarEvents = calendarEvents;
    }

    /**
     * arry constructor for convinience
     * @param events - array of recurring and singular events
     */
    public Calendarium(CalendarEvent... events){
        calendarEvents = new ArrayList<>();
        if (events != null && events.length > 0){
            calendarEvents.addAll(Arrays.asList(events));
        }
    }

    /**
     * creates a calendar and adding all due events to the specific dates
     *
     * @param begin - when to start the calendar
     * @param end - when to end
     * @param padEmptyDays - if true, a map entry with an empty list is created for dates, where no events are due
     * @return a map day -> all events
     */
    public EventMap createCalendar(LocalDate begin, LocalDate end, boolean padEmptyDays){
        EventMap result = new EventMap();   // keep it sorted

        if (end.isBefore(begin)){
            throw new IllegalArgumentException("Start date must not be after end date");
        }

        LocalDate current = begin;

        while (current.isBefore(end) || current.isEqual(end)){
            List<CalendarEvent> events = new ArrayList<>();
            for (CalendarEvent event: calendarEvents) {
                if (event.isDue(current)){
                    events.add(event);
                }
            }
            if (padEmptyDays || !events.isEmpty()){
                result.put(current, events);
            }

            current = current.plus(1, ChronoUnit.DAYS);
        }

        return result;
    }

}
