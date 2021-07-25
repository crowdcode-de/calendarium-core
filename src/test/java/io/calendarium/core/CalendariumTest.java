package io.calendarium.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import static io.calendarium.core.TestEvents.*;

class CalendariumTest {

    Calendarium probe1;

    @BeforeEach
    void before(){
        probe1 = new Calendarium(weeklyEvent);
    }

    @Test
    void createCalendar() {
        Map<LocalDate, List<CalendarEvent>> result = probe1.createCalendar(LocalDate.now(), LocalDate.now().plus(1, ChronoUnit.YEARS), true);
        assertNotNull(result);
        assertNotEquals(0, result.keySet().size());

        List<CalendarEvent> todaysEvents = result.get(NOW.toLocalDate());
        assertNotNull(todaysEvents);
        assertFalse(todaysEvents.isEmpty());
        assertEquals(1, todaysEvents.size());

        assertEquals(todaysEvents.iterator().next(),weeklyEvent);

        List<CalendarEvent> day2 = result.get(NOW.toLocalDate().plus(1, ChronoUnit.DAYS));
        assertNotNull(day2);
        assertTrue(day2.isEmpty());

        List<CalendarEvent> day3 = result.get(NOW.toLocalDate().plus(2, ChronoUnit.DAYS));
        assertNotNull(day3);
        assertTrue(day3.isEmpty());

        List<CalendarEvent> day4 = result.get(NOW.toLocalDate().plus(3, ChronoUnit.DAYS));
        assertNotNull(day4);
        assertTrue(day4.isEmpty());

        List<CalendarEvent> day5 = result.get(NOW.toLocalDate().plus(4, ChronoUnit.DAYS));
        assertNotNull(day5);
        assertTrue(day5.isEmpty());

        List<CalendarEvent> day6 = result.get(NOW.toLocalDate().plus(5, ChronoUnit.DAYS));
        assertNotNull(day6);
        assertTrue(day6.isEmpty());

        List<CalendarEvent> day7 = result.get(NOW.toLocalDate().plus(6, ChronoUnit.DAYS));
        assertNotNull(day7);
        assertTrue(day7.isEmpty());

        List<CalendarEvent> next = result.get(NOW.toLocalDate().plus(1, ChronoUnit.WEEKS));
        assertNotNull(next);
        assertFalse(next.isEmpty());
        assertEquals(1, next.size());

    }

    @Test
    void createCalendarBadParm() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            probe1.createCalendar(LocalDate.now().plus(1,ChronoUnit.DAYS), LocalDate.now(), false);
        });

    }
}