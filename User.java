import java.util.ArrayList;
import java.util.List;

public class User implements IObserver {
    private List<Subscription> subscriptions;

    public User() {
        this.subscriptions = new ArrayList<>();
    }

    public boolean register(String url, Frequency freq, Channel channel) {
        Subscription newSub = new Subscription(url, freq, channel);
        return subscriptions.add(newSub);
    }

    public boolean modify(String oldUrl, String newUrl, Frequency freq, Channel channel) {
        for (int i = 0; i < subscriptions.size(); i++) {
            if (subscriptions.get(i).getUrl().equals(oldUrl)) {
                subscriptions.set(i, new Subscription(newUrl, freq, channel));
                return true;
            }
        }
        return false;
    }

    public boolean cancel(String url) {
        for (int i = 0; i < subscriptions.size(); i++) {
            if (subscriptions.get(i).getUrl().equals(url)) {
                subscriptions.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Subscription> getSubs() {
        return subscriptions;
    }

    public void update(String url) {
        long currentTime = System.currentTimeMillis(); 
        
        for (int i = 0; i < subscriptions.size(); i++) {
            Subscription sub = subscriptions.get(i);
            
            if (sub.getUrl().equals(url)) {
                if (sub.canNotify(currentTime)) {
                    sub.getChannel().sendNotification(url);
                    sub.updateNotificationTime(currentTime); 
                } else {
                    System.out.println("Notification skipped for " + url + " (Frequency limit)");
                }
            }
        }
    }
}