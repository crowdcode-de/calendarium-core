package io.calendarium.core;

import java.time.LocalDateTime;

public interface YearlyEvent extends NMonthlyEvent{

    @Override
    default int getEveryNthMonth(){
        return 12;
    }
}
