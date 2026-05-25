public enum Frequency {
    ALWAYS(0),                   
    HOURLY(3600000),             // 60 * 60 * 1000 ms
    DAILY(86400000),             // 24 * 60 * 60 * 1000 ms
    WEEKLY(604800000);           // 7 * 24 * 60 * 60 * 1000 ms

    private final long timeInMillis;

    Frequency(long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }
}