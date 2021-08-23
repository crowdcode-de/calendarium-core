package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

public class QuartelyStrategy extends NMonthlyStrategy {


    public QuartelyStrategy(CalendarEvent event) {
        super(event);
    }

    @Override
    public int getEveryNthMonth() {
        return 3;
    }
}
