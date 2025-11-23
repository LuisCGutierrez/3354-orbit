package org.skylerlee;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Event implementation will be here.
 * For demonstration’s sake, this class only contains
 * the attributes: startTime, endTime
 * and the function: getDuration()
 */
public class Event {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Event(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime == null || endTime == null)
            throw new IllegalArgumentException("Event start or end time cannot be null.");
        if (endTime.isBefore(startTime))
            throw new IllegalArgumentException("Event end time cannot be before start time.");

        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Gets the duration of the event in minutes.
     * @return
     */
    public long getDuration() {
        return Duration.between(startTime, endTime).toMinutes();
    }
}
