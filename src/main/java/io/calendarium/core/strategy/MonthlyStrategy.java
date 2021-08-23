package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

/**
 * a monthly event handling strategy
 *
 * @since 1.0.0
 */
public class MonthlyStrategy extends NMonthlyStrategy {


    public MonthlyStrategy(CalendarEvent event) {
        super(event);
    }

    @Override
    public int getEveryNthMonth() {
        return 1;
    }
}
