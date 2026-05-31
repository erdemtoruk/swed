/**
 * This interface represents an observer.
 * 
 * @author Erdem Toruk
 * @version 1.3
 */
public interface IObserver {
    /**
     * A method for receiving system updates
     * 
     * @param url the address of website that received an update
     */
    void update(String url);
}