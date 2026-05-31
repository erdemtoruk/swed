/**
 * This interface represents a subject
 * 
 * @author Erdem Toruk
 * @version 1.3
 */
public interface ISubject {
    /**
     * Adds new observer to the subject
     * 
     * @param o the observer to be added
     */
    void addObserver(IObserver o);
    
    /**
     * Removes an existing observer from the subject
     * 
     * @param o the observer to be removed
     */
    void removeObserver(IObserver o);
    
    /**
     * Adds new url to the subject to track
     * 
     * @param url the address of website
     */
    void addUrl(String url);

    /**
     * Notifies all registered observers that website has been changed
     * 
     * @param url the address of website
     */
    void notifyObservers(String url);
}