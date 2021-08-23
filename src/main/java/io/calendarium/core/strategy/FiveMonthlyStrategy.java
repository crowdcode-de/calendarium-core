package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

/**
 * a five month interval event handling strategy
 *
 * @since 1.0.0
 */
public class FiveMonthlyStrategy extends NMonthlyStrategy {


    public FiveMonthlyStrategy(CalendarEvent event) {
        super(event);
    }

    @Override
    public int getEveryNthMonth() {
        return 5;
    }
}
