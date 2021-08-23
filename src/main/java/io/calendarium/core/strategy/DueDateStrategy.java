package io.calendarium.core.strategy;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * base interface for implementing a due date strategy
 *
 * @since 1.0.0
 */
public interface DueDateStrategy {

    boolean isDue(LocalDateTime dateTime);

    boolean isDue(LocalDate date);
}
