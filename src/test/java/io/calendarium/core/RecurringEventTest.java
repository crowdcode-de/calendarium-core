package io.calendarium.core;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecurringEventTest {

    public static final LocalDateTime NOW = LocalDateTime.now();

    public static final int month = NOW.getMonth().getValue();

    public static final LocalDateTime firstQuarter = LocalDateTime.of(NOW.getYear(),NOW.getMonth().getValue() % 3,NOW.getDayOfMonth(), NOW.getHour(), NOW.getMinute());
    public static final LocalDateTime firstHalf = LocalDateTime.of(NOW.getYear(),NOW.getMonth().getValue() % 6,NOW.getDayOfMonth(), NOW.getHour(), NOW.getMinute());

    public static final LocalDateTime lastQuarter = LocalDateTime.of(NOW.getYear(),((NOW.getMonth().getValue() % 3)+3) % 12,NOW.getDayOfMonth(), NOW.getHour(), NOW.getMinute());
    public static final LocalDateTime firstDayOfYear = LocalDateTime.of(NOW.getYear(), 1,1,0,0);
    public static final LocalDateTime firstOfFebruary = LocalDateTime.of(NOW.getYear(), 2,1,0,0);
    public static final LocalDateTime firstOfMarch = LocalDateTime.of(NOW.getYear(), 3,1,0,0);
    public static final LocalDateTime fourteenthJan = LocalDateTime.of(NOW.getYear(), 1,14,0,0);
    public static final LocalDateTime fourteenthJul = LocalDateTime.of(NOW.getYear(), 7,14,0,0);

    RecurringEvent dailyEvent       = new DailyEvent(CalendarEvent.Precision.DATE,"Daily Event", "Test Event", NOW, NOW);
    RecurringEvent weeklyEvent      = new WeeklyEvent(CalendarEvent.Precision.DATE, "Weekly Event", "Test Event Weekly", NOW, NOW, NOW.getDayOfWeek());
    RecurringEvent nMonthlyEvent    = new NMonthlyEvent(CalendarEvent.Precision.DATE, "Weekly Event", "Test Event Weekly", NOW, NOW,  NOW.getDayOfMonth());
    RecurringEvent quartelyEvent    = new QuartelyEvent(CalendarEvent.Precision.DATE, "Quarterly Event", "Test Event Weekly", NOW, firstQuarter);
    RecurringEvent halfYearEvent    = new HalfYearEvent(CalendarEvent.Precision.DATE, "HaryYear Event", "Test Event Weekly", NOW, firstHalf);
    RecurringEvent yearlyEvent      = new YearlyEvent(CalendarEvent.Precision.DATE, "Yearly Event", "Test Event Weekly", NOW, NOW);

    RecurringEvent twoMonthEvent    = new NMonthlyEvent(CalendarEvent.Precision.DATE, "Two Event", "Test Event Weekly", NOW, firstDayOfYear, 2);

    RecurringEvent halfYearEventSimp    = new HalfYearEvent(CalendarEvent.Precision.DATE, "HalfYear 14th Event", "Test Event Weekly", NOW, fourteenthJan);


    @Test
    void isDue() {
        assertTrue(dailyEvent.isDue(LocalDate.now()));
        assertTrue(weeklyEvent.isDue(LocalDate.now()));
        assertTrue(nMonthlyEvent.isDue(LocalDate.now()));
        assertTrue(quartelyEvent.isDue(LocalDate.now()));
        assertTrue(halfYearEvent.isDue(LocalDate.now()));
        assertTrue(yearlyEvent.isDue(LocalDate.now()));
        assertTrue(quartelyEvent.isDue(lastQuarter));

        assertTrue(twoMonthEvent.isDue(firstDayOfYear));
        assertFalse(twoMonthEvent.isDue(firstOfFebruary));
        assertTrue(twoMonthEvent.isDue(firstOfMarch));

        assertFalse(halfYearEventSimp.isDue(firstOfMarch));
        assertTrue(halfYearEventSimp.isDue(fourteenthJan));
        assertTrue(halfYearEventSimp.isDue(fourteenthJul));
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