public class Subscription {
    private String url;
    private int freq;
    private String channel;

    public Subscription(String url, int freq, String channel) {
        this.url = url;
        this.freq = freq;
        this.channel = channel;
    }

    public String getUrl() { 
        return url; 
    }
    
    public int getFreq() { 
        return freq; 
    }
    
    public String getChannel() { 
        return channel; 
    }
}
