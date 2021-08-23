package io.calendarium.core.strategy;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DueDateStrategy {

    boolean isDue(LocalDateTime dateTime);

    boolean isDue(LocalDate date);
}
