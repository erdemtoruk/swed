import java.util.ArrayList;
import java.util.List;

/**
 * Represents a subscriber who tracks websites and receives notifications
 *
 * @author Erdem Toruk
 * @version 1.3
 */
public class User implements IObserver {
    /** The list of active subscriptions for this user */
    private final List<Subscription> subscriptions;

    /** The main system that tracks websites and sends notifications */
    private final ISubject system;

    /**
     * Construct a new user and automatically registers it to the system
     *
     * @param system the main notification system
     */
    public User(ISubject system) {
        this.subscriptions = new ArrayList<>();
        this.system = system;

        system.addObserver(this);
    }

    /**
     * Subscribes the user to a new website
     *
     * @param url the website address to track
     * @param freq the notification frequency
     * @param channel the communication channel for notifications
     * @return true if successfully registered, false otherwise
     */
    public boolean register(String url, Frequency freq, Channel channel) {
        Subscription newSub = new Subscription(url, freq, channel);
        boolean isAdded = subscriptions.add(newSub);

        if(isAdded){
            system.addUrl(url);
        }

        return isAdded;
    }

    /**
     * Modifies an existing subscription by completely replacing it
     *
     * @param oldUrl the old url being tracked
     * @param newUrl the new url to track
     * @param freq the new frequency
     * @param channel the communication channel for notifications
     * @return true if updated successfully, false if the old url was not found
     */
    public boolean modify(String oldUrl, String newUrl, Frequency freq, Channel channel) {
        for (int i = 0; i < subscriptions.size(); i++) {
            if (subscriptions.get(i).getUrl().equals(oldUrl)) {
                subscriptions.set(i, new Subscription(newUrl, freq, channel));

                system.addUrl(newUrl);
                return true;
            }
        }
        return false;
    }

    /**
     * Cancels an existing subscription
     *
     * @param url the url to remove from the tracking list
     * @return true if canceled successfully, false if the url was not found
     */
    public boolean cancel(String url) {
        for (int i = 0; i < subscriptions.size(); i++) {
            if (subscriptions.get(i).getUrl().equals(url)) {
                subscriptions.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the list of active subscriptions for this user
     *
     * @return list of subscriptions
     */
    public List<Subscription> getSubs() {
        return subscriptions;
    }

    /**
     * Receives updates from the system and triggers notifications 
     * if the frequency rules allow.
     *
     * @param url the website url
     */
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