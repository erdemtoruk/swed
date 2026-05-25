public class Subscription {
    private String url;
    private Frequency freq; 
    private Channel channel;
    private long lastNotificationTime; 

    public Subscription(String url, Frequency freq, Channel channel) {
        this.url = url;
        this.freq = freq;
        this.channel = channel;
        this.lastNotificationTime = 0; 
    }

    public String getUrl() { 
        return url; 
    }
    
    public Frequency getFreq() { 
        return freq; 
    }
    
    public Channel getChannel() { 
        return channel; 
    }

    public boolean canNotify(long currentTime) {
        return (currentTime - lastNotificationTime) >= freq.getTimeInMillis();
    }

    public void updateNotificationTime(long currentTime) {
        this.lastNotificationTime = currentTime;
    }
}