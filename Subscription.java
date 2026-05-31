/**
 * Represents a user's subscription to a specific website
 * Stores the target URL, the notification frequency, and the delivery channel
 *
 * @author Erdem Toruk
 * @version 1.3
 */
public class Subscription {
    /** The website address being tracked */
    private final String url;

    /** The frequency rules for notifications */
    private final Frequency freq;

    /** The communication channel used to send notifications */
    private final Channel channel;

    /** The timestamp of the last sent notification in milliseconds */
    private long lastNotificationTime; 

    /**
     * Constructs a new subscription with the specified details
     *
     * @param url the address of the website
     * @param frequency the notification frequency
     * @param channel the communication channel for notifications
     */
    public Subscription(String url, Frequency freq, Channel channel) {
        this.url = url;
        this.freq = freq;
        this.channel = channel;
        this.lastNotificationTime = 0; 
    }

    /**
     * Gets the tracked website URL
     *
     * @return the website URL
     */
    public String getUrl() { 
        return url; 
    }
    
    /**
     * Gets the notification frequency
     *
     * @return the frequency
     */
    public Frequency getFreq() { 
        return freq; 
    }
    
    /**
     * Gets the communication channel
     *
     * @return the communication channel
     */
    public Channel getChannel() { 
        return channel; 
    }

    /**
     * Checks if enough time has passed to send a new notification 
     * based on the frequency rules
     *
     * @param currentTime the current system time in milliseconds
     * @return true if a notification can be sent, false otherwise
     */
    public boolean canNotify(long currentTime) {
        return (currentTime - lastNotificationTime) >= freq.getTimeInMillis();
    }

    /**
     * Updates the timestamp of the last sent notification
     *
     * @param time the current system time in milliseconds
     */
    public void updateNotificationTime(long currentTime) {
        this.lastNotificationTime = currentTime;
    }
}