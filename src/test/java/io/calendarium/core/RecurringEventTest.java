package io.calendarium.core;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RecurringEventTest {

    public static final LocalDateTime NOW = LocalDateTime.now();

    public static final int month = NOW.getMonth().getValue();

    public static final LocalDateTime firstQuarter = LocalDateTime.of(NOW.getYear(),NOW.getMonth().getValue() % 3,NOW.getDayOfMonth(), NOW.getHour(), NOW.getMinute());


    RecurringEvent dailyEvent       = new DailyEvent(CalendarEvent.Precision.DATE,"Daily Event", "Test Event", NOW, NOW);
    RecurringEvent weeklyEvent      = new WeeklyEvent(CalendarEvent.Precision.DATE, "Weekly Event", "Test Event Weekly", NOW, NOW, NOW.getDayOfWeek());
    RecurringEvent nMonthlyEvent    = new NMonthlyEvent(CalendarEvent.Precision.DATE, "Weekly Event", "Test Event Weekly", NOW, NOW,  NOW.getDayOfMonth(), NOW.getMonth().getValue());
    RecurringEvent quartelyEvent    =  new QuartelyEvent(CalendarEvent.Precision.DATE, "Weekly Event", "Test Event Weekly", NOW, firstQuarter, NOW.getDayOfMonth());
    RecurringEvent halfYearEvent    = new HalfYearEvent(CalendarEvent.Precision.DATE, "Weekly Event", "Test Event Weekly", NOW, NOW, 14);
    RecurringEvent yearlyEvent      = new YearlyEvent(CalendarEvent.Precision.DATE, "Weekly Event", "Test Event Weekly", NOW, NOW, 14);

    @Test
    void isDue() {
        assertTrue(dailyEvent.isDue(LocalDate.now()));
        assertTrue(weeklyEvent.isDue(LocalDate.now()));
        assertTrue(nMonthlyEvent.isDue(LocalDate.now()));
        assertTrue(quartelyEvent.isDue(LocalDate.now()));
        assertTrue(halfYearEvent.isDue(LocalDate.now()));
        assertTrue(yearlyEvent.isDue(LocalDate.now()));

    }

    @Test
    void testIsDue() {
    }

    @Test
    void getPrecision() {
    }

    @Test
    void getName() {
    }

    @Test
    void getDescription() {
    }

    @Test
    void getCreated() {
    }
}