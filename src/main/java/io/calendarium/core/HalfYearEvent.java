package io.calendarium.core;

import java.time.LocalDateTime;

public interface HalfYearEvent extends NMonthlyEvent{

    @Override
    default int getEveryNthMonth() {
        return 6;
    }
}
