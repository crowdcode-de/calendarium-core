package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

public class FourMonthlyStrategy extends NMonthlyStrategy {


    public FourMonthlyStrategy(CalendarEvent event) {
        super(event);
    }

    @Override
    public int getEveryNthMonth() {
        return 4;
    }
}
