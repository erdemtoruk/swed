/**
 * This class represents a mail channel
 * 
 * @author Erdem Toruk
 * @version 1.3
 */
public class MailChannel extends Channel {
    /**
     * Prints a message to console
     * 
     * @param url the address of website
     */
    public void sendNotification(String url) {
        System.out.println("Sending EMAIL: The website " + url + " has been updated!");
    }
}