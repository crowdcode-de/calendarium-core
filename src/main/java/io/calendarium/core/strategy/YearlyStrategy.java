package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

public class YearlyStrategy extends NMonthlyStrategy {

    public YearlyStrategy(CalendarEvent event) {
        super(event);
    }

    @Override
    public int getEveryNthMonth() {
        return 12;
    }
}
