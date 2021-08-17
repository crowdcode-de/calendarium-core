package io.calendarium.core;

import io.calendarium.core.impl.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class TestEvents {

    public static final LocalDateTime NOW = LocalDateTime.now();

    public static final int month = NOW.getMonth().getValue();

    public static final LocalDateTime firstQuarter = LocalDateTime.of(NOW.getYear(), NOW.getMonth().getValue() % 3, NOW.getDayOfMonth(), NOW.getHour(), NOW.getMinute());
    public static final LocalDateTime firstHalf = LocalDateTime.of(NOW.getYear(), NOW.getMonth().getValue() % 6, NOW.getDayOfMonth(), NOW.getHour(), NOW.getMinute());

    public static final LocalDateTime lastQuarter = LocalDateTime.of(NOW.getYear(), ((NOW.getMonth().getValue() % 3) + 3) % 12, NOW.getDayOfMonth(), NOW.getHour(), NOW.getMinute());
    public static final LocalDateTime firstDayOfYear = LocalDateTime.of(NOW.getYear(), 1, 1, 0, 0);
    public static final LocalDateTime firstOfFebruary = LocalDateTime.of(NOW.getYear(), 2, 1, 0, 0);
    public static final LocalDateTime firstOfMarch = LocalDateTime.of(NOW.getYear(), 3, 1, 0, 0);
    public static final LocalDateTime fourteenthJan = LocalDateTime.of(NOW.getYear(), 1, 14, 0, 0);
    public static final LocalDateTime fourteenthJul = LocalDateTime.of(NOW.getYear(), 7, 14, 0, 0);
    public static final LocalDateTime nextWeekly = NOW.plus(7, ChronoUnit.DAYS);
    public static final LocalDateTime nextYear = NOW.plus(1, ChronoUnit.YEARS);
    public static final LocalDateTime nextNextYear = NOW.plus(2, ChronoUnit.YEARS).minus(1, ChronoUnit.DAYS);
    public static final LocalDateTime theDayAfterTomorrow = nextNextYear.plus(1,ChronoUnit.DAYS);

    public static final LocalDate someDay = LocalDate.of(NOW.getYear(), 10, 31);

    public static final RecurringEvent dailyEvent = new DailyEventImpl(UUID.randomUUID(), CalendarEvent.Precision.DATE, "Daily Event", "Test Event", NOW, NOW, nextYear);
    public static final RecurringEvent weeklyEvent = new WeeklyEventImpl(UUID.randomUUID(), CalendarEvent.Precision.DATE, "Weekly Event", "Test Event Weekly", NOW, NOW, NOW.getDayOfWeek(),nextYear);
    public static final RecurringEvent nMonthlyEvent = new NMonthlyEventImpl(UUID.randomUUID(), CalendarEvent.Precision.DATE, "Weekly Event", "Test Event Weekly", NOW, NOW, NOW.getDayOfMonth(), nextYear);
    public static final RecurringEvent quartelyEvent = new QuartelyEventImpl(UUID.randomUUID(), CalendarEvent.Precision.DATE, "Quarterly Event", "Test Event Weekly", NOW, firstQuarter, nextYear);
    public static final RecurringEvent halfYearEvent = new HalfYearEventImpl(UUID.randomUUID(), CalendarEvent.Precision.DATE, "HaryYear Event", "Test Event Weekly", NOW, firstHalf, nextYear);
    public static final RecurringEvent yearlyEvent = new YearlyEventImpl(UUID.randomUUID(), CalendarEvent.Precision.DATE, "Yearly Event", "Test Event Weekly", NOW, NOW, nextYear);
    public static final RecurringEvent twoMonthEvent = new NMonthlyEventImpl(UUID.randomUUID(), CalendarEvent.Precision.DATE, "Two Event", "Test Event Weekly", NOW, firstDayOfYear, 2, nextYear);
    public static final RecurringEvent halfYearEventSimp = new HalfYearEventImpl(UUID.randomUUID(), CalendarEvent.Precision.DATE, "HalfYear 14th Event", "Test Event Weekly", NOW, fourteenthJan, nextYear);
    public static final SingularCalendarEvent singleEvent = new SingularCalendarEventImpl(UUID.randomUUID(), CalendarEvent.Precision.DATE, "Singular Event", "Test Event Single", NOW, NOW);

}
