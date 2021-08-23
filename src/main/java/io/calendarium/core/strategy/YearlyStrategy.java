package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;


/**
 * a 12 month based strategy
 *
 * @since 1.0.0
 */
public class YearlyStrategy extends NMonthlyStrategy {

    public YearlyStrategy(CalendarEvent event) {
        super(event);
    }

    @Override
    public int getEveryNthMonth() {
        return 12;
    }
}
