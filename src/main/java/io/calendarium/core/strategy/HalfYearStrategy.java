package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

public class HalfYearStrategy extends NMonthlyStrategy {

    public HalfYearStrategy(CalendarEvent event) {
        super(event);
    }

    @Override
    public int getEveryNthMonth() {
        return 6;
    }
}
