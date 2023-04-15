import java.util.Scanner;

public class MailConstant {
    static Scanner sc = new Scanner(System.in);

    public static final String SENDER="supriyagro2001@gmail.com";

    public static String MailRECIVER(){
        System.out.println("Enter the Reciver Email Address: ");

        return sc.next();
    }

    public static String SUBJECT="Warning: Potential Threat Detected - Steps to Ensure Safety";

    public static String CONTENT="This Message is for Security check...! \n https://media.tenor.com/X_Yo4A3iOyMAAAAS/hacking.gif";

}
