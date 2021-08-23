package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

public class MonthlyStrategy extends NMonthlyStrategy {


    public MonthlyStrategy(CalendarEvent event) {
        super(event);
    }

    @Override
    public int getEveryNthMonth() {
        return 1;
    }
}
