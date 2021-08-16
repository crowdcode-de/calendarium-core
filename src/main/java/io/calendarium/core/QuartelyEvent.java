package io.calendarium.core;

import java.time.LocalDateTime;

public interface QuartelyEvent extends NMonthlyEvent{


    @Override
    default int getEveryNthMonth() {
        return 3;
    }
}
