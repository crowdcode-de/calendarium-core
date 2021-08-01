# Calendarium

(C) 2021 Crowdcode GmbH+Co.KG

## Abstract

This is Calendarium, a free easy-to-use, multi-purpose utility for handling recurring entries inside
a temporal context

## License

This utility is shipped under Apache License 2.0 

## Usage

### For the unpatient

#### instantiate the events and give it to the Calendarium

```
final LocalDateTime NOW = LocalDateTime.now();
final RecurringEvent weeklyEvent = new WeeklyEvent(CalendarEvent.Precision.DATE, "Weekly Event", "Test Event Weekly", NOW, NOW, NOW.getDayOfWeek(),nextYear);
Calendarium probe1 = new Calendarium(weeklyEvent);
```

#### get you stuff done by calendarium

```
EventMap result = probe1.createCalendar(LocalDate.now(), LocalDate.now().plus(1, ChronoUnit.YEARS), true);
List<CalendarEvent> todaysEvents = result.get(NOW.toLocalDate());
```

For more details check CalendariumTest class