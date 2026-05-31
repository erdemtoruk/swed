import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * The core system class that tracks website contents in the background
 * and notifies registered observers when a change is detected
 *
 * @author Erdem Toruk
 * @version 1.3
 */
public class AppSystem implements ISubject {
    /** The list of registered observers */
    private final List<IObserver> observers;

    /** A map storing website URLs and their last known contents */
    private final Map<String, String> contents;

    /** The currently active strategy used for website comparison */
    private IComparison currentStrategy;

    /**
     * Constructs a new AppSystem
     */
    public AppSystem() {
        this.observers = new ArrayList<>();
        this.contents = new HashMap<>();
        this.currentStrategy = new SizeComparison();
    }

    /**
     * Changes the website comparison strategy of the system
     *
     * @param newStrategy the new comparison strategy
     */
    public void setStrategy(IComparison strategy){
        this.currentStrategy = strategy;
    }

    /**
     * Registers a new observer to the system
     *
     * @param o the observer object to be registered
     */
    public void addObserver(IObserver o) {
        if (o != null && !observers.contains(o)) {
            observers.add(o);
        }
    }

    /**
     * Removes the specified observer from the system's registration list
     *
     * @param o the observer object to be removed
     */
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    /**
     * Notifies all registered observers when a change is detected at the specified url
     *
     * @param url the address of the updated website
     */
    public void notifyObservers(String url) {
        for (int i = 0; i < observers.size(); i++) {
            IObserver o = observers.get(i);
            o.update(url);
        }
    }

    /**
     * Adds a new website url to the tracking list.
     * If the url is already registered, it does not add it again and preserves existing data
     *
     * @param url the address of the new website to be tracked
     */
    public void addUrl(String url){
        if (!contents.containsKey(url)) {
            contents.put(url, "");
        }
    }

    /**
     * Checks all websites in the system with the provided live web data
     * Notifies observers for the websites that have changed
     *
     * @param liveWebData a map containing the latest urls and their current contents
     */
    public void check(Map<String, String> webData) {
        for (String url : contents.keySet()) {
            String oldContent = contents.get(url);
            String newContent = webData.get(url);

            if (!currentStrategy.compare(oldContent, newContent)) {
                contents.put(url, newContent);
                notifyObservers(url);
            }
        }
    }
}
