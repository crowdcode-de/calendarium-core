package io.calendarium.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TestEvents {

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
    public static final LocalDateTime nextWeekly = NOW.plus(7, ChronoUnit.DAYS);

    public static final LocalDate someDay = LocalDate.of(NOW.getYear(), 10,31);

    public static final RecurringEvent dailyEvent       = new DailyEvent(CalendarEvent.Precision.DATE,"Daily Event", "Test Event", NOW, NOW);
    public static final RecurringEvent weeklyEvent      = new WeeklyEvent(CalendarEvent.Precision.DATE, "Weekly Event", "Test Event Weekly", NOW, NOW, NOW.getDayOfWeek());
    public static final RecurringEvent nMonthlyEvent    = new NMonthlyEvent(CalendarEvent.Precision.DATE, "Weekly Event", "Test Event Weekly", NOW, NOW,  NOW.getDayOfMonth());
    public static final RecurringEvent quartelyEvent    = new QuartelyEvent(CalendarEvent.Precision.DATE, "Quarterly Event", "Test Event Weekly", NOW, firstQuarter);
    public static final RecurringEvent halfYearEvent    = new HalfYearEvent(CalendarEvent.Precision.DATE, "HaryYear Event", "Test Event Weekly", NOW, firstHalf);
    public static final RecurringEvent yearlyEvent      = new YearlyEvent(CalendarEvent.Precision.DATE, "Yearly Event", "Test Event Weekly", NOW, NOW);
    public static final RecurringEvent twoMonthEvent    = new NMonthlyEvent(CalendarEvent.Precision.DATE, "Two Event", "Test Event Weekly", NOW, firstDayOfYear, 2);
    public static final RecurringEvent halfYearEventSimp    = new HalfYearEvent(CalendarEvent.Precision.DATE, "HalfYear 14th Event", "Test Event Weekly", NOW, fourteenthJan);
    public static final SingularCalendarEvent singleEvent = new SingularCalendarEvent(CalendarEvent.Precision.DATE,"Singular Event","Test Event Single",NOW,NOW);

}
