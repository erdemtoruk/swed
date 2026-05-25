public class MailChannel extends Channel {
    public void sendNotification(String url) {
        System.out.println("Sending EMAIL: The website " + url + " has been updated!");
    }
}