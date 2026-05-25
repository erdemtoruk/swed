public class Main {
    public static void main(String[] args) {
        AppSystem controller = new AppSystem();
        User u1 = new User();
        
        u1.register("https://something.com", Frequency.DAILY, new MailChannel());
        u1.modify("https://something.com", "https://google.com", Frequency.HOURLY, new SmsChannel());

        controller.addObserver(u1);
        
        for (int i = 0; i < 4; i++) {
            System.out.println("----------------");
            controller.check("https://google.com");
        }


        u1.modify("https://google.com", "https://youtube.com", Frequency.ALWAYS, new MailChannel());

        for (int i = 0; i < 4; i++) {
            System.out.println("----------------");
            controller.check("https://youtube.com");
        }
    }
}