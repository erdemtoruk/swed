/**
 * This class represents a sms channel
 * 
 * @author Erdem Toruk
 * @version 1.3
 */
public class SmsChannel extends Channel {
    /**
     * Prints a message to console
     * 
     * @param url the address of website
     */
    public void sendNotification(String url) {
        System.out.println("Sending SMS: The website " + url + " has been updated!");
    }
}