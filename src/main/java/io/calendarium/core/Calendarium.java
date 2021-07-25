package io.calendarium.core;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Calendarium extends GregorianCalendar {
    private final List<CalendarEvent> calendarEvents;

    public Calendarium(List<CalendarEvent> calendarEvents) {
        this.calendarEvents = calendarEvents;


    }

    public Calendarium(CalendarEvent... events){
        calendarEvents = new ArrayList<>();
        if (events != null && events.length > 0){
            calendarEvents.addAll(Arrays.asList(events));
        }
    }

    public Map<LocalDate, List<CalendarEvent>> createCalendar(LocalDate begin, LocalDate end, boolean padEmptyDays){
        Map<LocalDate, List<CalendarEvent>> result = new TreeMap<>();   // keep it sorted

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
