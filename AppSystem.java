import java.util.ArrayList;
import java.util.List;

public class AppSystem {
    private List<User> users;

    public AppSystem() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean check(String url) {
        System.out.println("Checking URL for updates: " + url);
        return true; 
    }

    public boolean notifyUser(User user) {
        List<Subscription> subs = user.getSubs();
        for (Subscription sub : subs) {
            System.out.println("Notification sent via " + sub.getChannel() + " for website: " + sub.getUrl());
        }
        return true;
    }
}
