package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

/**
 * two month based event handling strategy
 *
 * @since 1.0.0
 */
public class TwoMonthlyStrategy extends NMonthlyStrategy {


    public TwoMonthlyStrategy(CalendarEvent event) {
        super(event);
    }

    @Override
    public int getEveryNthMonth() {
        return 2;
    }
}
