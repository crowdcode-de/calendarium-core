package io.calendarium.core.strategy;

import io.calendarium.core.CalendarEvent;

/**
 * a three month based event handling strategy
 *
 * @since 1.0.0
 */
public class QuartelyStrategy extends NMonthlyStrategy {


    public QuartelyStrategy(CalendarEvent event) {
        super(event);
    }

    @Override
    public int getEveryNthMonth() {
        return 3;
    }
}
