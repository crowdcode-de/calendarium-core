package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;


/**
 * a four month event handling strategy
 *
 * @since 1.0.0
 */
public class FourMonthlyStrategy extends NMonthlyStrategy {


    public FourMonthlyStrategy(CalendarEvent event) {
        super(event);
    }

    @Override
    public int getEveryNthMonth() {
        return 4;
    }
}
