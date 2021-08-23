package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

public class TwoMonthlyStrategy extends NMonthlyStrategy {


    public TwoMonthlyStrategy(CalendarEvent event) {
        super(event);
    }

    @Override
    public int getEveryNthMonth() {
        return 2;
    }
}
