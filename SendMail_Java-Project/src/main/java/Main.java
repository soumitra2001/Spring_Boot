public class Main {
    public static void main(String[] args) {
        System.out.println("This Application is Suppose to Send Mail");

        // Prepare for sending Mail

        MailHandler mailer = new MailHandler();
        mailer.sendMail();
    }
}
