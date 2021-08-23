package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

/**
 * a six month event handling strategy
 *
 * @since 1.0.0
 */
public class HalfYearStrategy extends NMonthlyStrategy {

    public HalfYearStrategy(CalendarEvent event) {
        super(event);
    }

    @Override
    public int getEveryNthMonth() {
        return 6;
    }
}
