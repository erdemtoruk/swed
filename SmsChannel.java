public class SmsChannel extends Channel {
    public void sendNotification(String url) {
        System.out.println("Sending SMS: The website " + url + " has been updated!");
    }
}