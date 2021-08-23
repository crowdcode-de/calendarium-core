package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

public class FiveMonthlyStrategy extends NMonthlyStrategy {


    public FiveMonthlyStrategy(CalendarEvent event) {
        super(event);
    }

    @Override
    public int getEveryNthMonth() {
        return 5;
    }
}
