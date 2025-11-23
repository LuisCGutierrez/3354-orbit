package org.skylerlee;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Uses Black Box Testing (checking the outputs and comparing them to the expected results)
 * along with Boundary Value Analysis (edge cases)
 */
class EventTest {

    @org.junit.jupiter.api.Test
    public void testNormalDuration() {
        Event event = new Event(
                LocalDateTime.of(2025, 11, 21, 1, 0),
                LocalDateTime.of(2025, 11, 21, 3, 0)
        );

        assertEquals(120, event.getDuration());
    }

    @org.junit.jupiter.api.Test
    public void testZeroDuration() {
        Event event = new Event(
                LocalDateTime.of(2025, 11, 21, 1, 0),
                LocalDateTime.of(2025, 11, 21, 1, 0)
        );

        assertEquals(0, event.getDuration());
    }

    @org.junit.jupiter.api.Test
    public void testEndBeforeStart() {
        //If the end is before start, the constructor will throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Event(
                    LocalDateTime.of(2025, 11, 21, 7, 0),
                    LocalDateTime.of(2025, 11, 21, 2, 0)
            );
        });
    }

    @org.junit.jupiter.api.Test
    public void testNullDuration() {
        //If any time is null, the constructor will throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Event(
                    null,
                    null
            );
        });
    }
}