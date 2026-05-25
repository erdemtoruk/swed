import java.util.ArrayList;
import java.util.List;

public class AppSystem implements ISubject {
    private List<IObserver> observers;

    public AppSystem() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(IObserver o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    public void notifyObservers(String url) {
        for (int i = 0; i < observers.size(); i++) {
            IObserver o = observers.get(i);
            o.update(url);
        }
    }

    public void check(String url) {
        System.out.println("Checking URL for updates: " + url);

        if (Math.random() > 0.5) {
            System.out.println("Update found for " + url + "! Notifying observers...");
            notifyObservers(url);
        } else {
            System.out.println("No updates found for " + url + " at this time.");
        }
    }
}
