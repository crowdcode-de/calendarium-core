package io.calendarium.core;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static io.calendarium.core.TestEvents.*;
import static org.junit.jupiter.api.Assertions.*;

class RecurringEventTest {

    @Test
    void isDue() {
        assertTrue(dailyEvent.isDue(LocalDate.now()));
        assertTrue(weeklyEvent.isDue(LocalDate.now()));
        assertTrue(fourMonthEvent.isDue(LocalDate.now()));
        assertTrue(fiveMonthlyEvent.isDue(LocalDate.now()));
        assertTrue(quartelyEvent.isDue(LocalDate.now()));
        assertTrue(halfYearEvent.isDue(LocalDate.now()));
        assertTrue(yearlyEvent.isDue(LocalDate.now()));

        assertTrue(weeklyEvent.isDue(nextWeekly));

        assertFalse(yearlyEvent.isDue(someDay));
        assertFalse(fourMonthEvent.isDue(someDay));

        assertTrue(quartelyEvent.isDue(lastQuarter));

        assertTrue(twoMonthEvent.isDue(firstDayOfYear));
        assertFalse(twoMonthEvent.isDue(firstOfFebruary));
        assertTrue(twoMonthEvent.isDue(firstOfMarch));

        assertFalse(halfYearEventSimp.isDue(firstOfMarch));
        assertTrue(halfYearEventSimp.isDue(fourteenthJan));
        assertTrue(halfYearEventSimp.isDue(fourteenthJul));
        assertTrue(singleEvent.isDue(NOW));
    }

    @Test
    public void testRepeatUntil(){
        assertFalse(yearlyEvent.isDue(nextNextYear));
        assertFalse(halfYearEvent.isDue(nextNextYear));
        assertFalse(weeklyEvent.isDue(theDayAfterTomorrow));
        assertFalse(dailyEvent.isDue(theDayAfterTomorrow));
        assertFalse(halfYearEventSimp.isDue(theDayAfterTomorrow));
        assertFalse(quartelyEvent.isDue(theDayAfterTomorrow));
    }

    @Test
    void getPrecision() {
        assertTrue(dailyEvent.getPrecision().equals(CalendarEvent.Precision.DATE));
        assertTrue(weeklyEvent.getPrecision().equals(CalendarEvent.Precision.DATE));
        assertTrue(fourMonthEvent.getPrecision().equals(CalendarEvent.Precision.DATE));
        assertTrue(quartelyEvent.getPrecision().equals(CalendarEvent.Precision.DATE));
        assertTrue(halfYearEvent.getPrecision().equals(CalendarEvent.Precision.DATE));
        assertTrue(yearlyEvent.getPrecision().equals(CalendarEvent.Precision.DATE));
        assertTrue(twoMonthEvent.getPrecision().equals(CalendarEvent.Precision.DATE));
        assertTrue(halfYearEventSimp.getPrecision().equals(CalendarEvent.Precision.DATE));
        assertTrue(singleEvent.getPrecision().equals(CalendarEvent.Precision.DATE));
    }

    @Test
    void getName() {
        assertNotNull(dailyEvent.getName());
        assertNotNull(weeklyEvent.getName());
        assertNotNull(fiveMonthlyEvent.getName());
        assertNotNull(fourMonthEvent.getName());
        assertNotNull(twoMonthEvent.getName());
        assertNotNull(quartelyEvent.getName());
        assertNotNull(halfYearEvent.getName());
        assertNotNull(yearlyEvent.getName());
        assertNotNull(twoMonthEvent.getName());
        assertNotNull(halfYearEventSimp.getName());
        assertNotNull(singleEvent.getName());
    }

    @Test
    void getDescription() {
        assertNotNull(dailyEvent.getDescription());
        assertNotNull(weeklyEvent.getDescription());
        assertNotNull(twoMonthEvent.getDescription());
        assertNotNull(fourMonthEvent.getDescription());
        assertNotNull(fiveMonthlyEvent.getDescription());
        assertNotNull(quartelyEvent.getDescription());
        assertNotNull(halfYearEvent.getDescription());
        assertNotNull(yearlyEvent.getDescription());
        assertNotNull(twoMonthEvent.getDescription());
        assertNotNull(halfYearEventSimp.getDescription());
        assertNotNull(singleEvent.getDescription());
    }

    @Test
    void getCreated() {
        assertEquals(dailyEvent.getCreated(), NOW);
        assertEquals(weeklyEvent.getCreated(), NOW);
        assertEquals(twoMonthEvent.getCreated(), NOW);
        assertEquals(fourMonthEvent.getCreated(), NOW);
        assertEquals(fiveMonthlyEvent.getCreated(), NOW);
        assertEquals(quartelyEvent.getCreated(), NOW);
        assertEquals(halfYearEvent.getCreated(), NOW);
        assertEquals(yearlyEvent.getCreated(), NOW);
        assertEquals(twoMonthEvent.getCreated(), NOW);
        assertEquals(halfYearEventSimp.getCreated(), NOW);
        assertEquals(singleEvent.getCreated(), NOW);
    }

    @Test
    void getDueDate(){
        assertEquals(singleEvent.getDueDateTime(), NOW);
    }
}