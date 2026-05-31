/**
 * Represents the notification frequency options for subscriptions
 *
 * @author Erdem Toruk
 * @version 1.3
 */
public enum Frequency {
    /** Sends a notification immediately on every change. */
    ALWAYS(0L),
    /** Waits at least 1 hour between notifications. */                  
    HOURLY(3600000L),
    /** Waits at least 1 day between notifications. */
    DAILY(86400000L),
    /** Waits at least 1 week between notifications. */
    WEEKLY(604800000L);

    /** The time interval in milliseconds. */
    private final long timeInMillis;

    /**
     * Constructs a Frequency with the specified time interval
     *
     * @param timeInMillis the duration of the frequency in milliseconds
     */
    Frequency(long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

    /**
     * Gets the time interval of the frequency
     *
     * @return the time interval in milliseconds
     */
    public long getTimeInMillis() {
        return timeInMillis;
    }
}