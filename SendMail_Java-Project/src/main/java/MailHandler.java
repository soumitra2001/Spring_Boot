import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {

    public void sendMail(){
        String host="smtp.gmail.com";

        Properties props=System.getProperties();

        props.put("mail.smtp.host",host);
        props.put("mail.smtp.port",465);
        props.put("mail.smtp.ssl.enable",true);
        props.put("mail.smtp.auth",true);

        Session session = Session.getInstance(props,new MailAuthenticator());

        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(MailConstant.SENDER);
            message.setRecipients(Message.RecipientType.TO,MailConstant.MailRECIVER());

            message.setSubject(MailConstant.SUBJECT);
            message.setText(MailConstant.CONTENT);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Mail Send Successfully");

    }

}
