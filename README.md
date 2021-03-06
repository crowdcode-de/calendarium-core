# Calendarium

(C) 2021 Crowdcode GmbH+Co.KG

## Abstract

This is Calendarium, a free easy-to-use, multi-purpose utility for handling recurring entries inside
a temporal context.

## License

This utility is shipped under Apache License 2.0

## Usage

There are multiple ways to cope with the Event classes; instantiate the interface (e.g. when you make use of persistent
beans) or make use of the default implementation (located under impl), which come as value objects (final properties).
The decision logic to determine a due event has been put into strategy objects.

The CalendarEvent will determine the matching event handling strategy and check for due using this object.

### For the unpatient

#### instantiate the events and give it to the Calendarium

```
final LocalDateTime NOW = LocalDateTime.now();
final LocalDateTime firstDayOfYear = LocalDateTime.of(NOW.getYear(), 1, 1, 0, 0);
final LocalDateTime nextYear = NOW.plus(1, ChronoUnit.YEARS);
final CalendarEvent twoMonthEvent = new TwoMonthlyEventImpl(UUID.randomUUID(), CalendarEvent.Precision.DATE, "Two Event", "Test Event Weekly", NOW, firstDayOfYear, nextYear);
Calendarium probe1 = new Calendarium(twoMonthEvent);
```

#### get you stuff done by calendarium

```
EventMap result = probe1.createCalendar(LocalDate.now(), LocalDate.now().plus(1, ChronoUnit.YEARS), true);
List<CalendarEvent> todaysEvents = result.get(NOW.toLocalDate());
```

For more details check CalendariumTest class

