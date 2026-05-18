import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Subscription> subscriptions;

    public User() {
        this.subscriptions = new ArrayList<>();
    }

    public boolean register(String url, int freq, String channel) {
        Subscription newSub = new Subscription(url, freq, channel);
        return subscriptions.add(newSub);
    }

    public boolean modify(String oldUrl, String newUrl, int freq, String channel) {
        for (int i = 0; i < subscriptions.size(); i++) {
            if (subscriptions.get(i).getUrl().equals(oldUrl)) {
                subscriptions.set(i, new Subscription(newUrl, freq, channel));
                return true;
            }
        }
        return false;
    }

    public boolean cancel(String url) {
        return subscriptions.removeIf(sub -> sub.getUrl().equals(url));
    }

    public List<Subscription> getSubs() {
        return subscriptions;
    }
}
