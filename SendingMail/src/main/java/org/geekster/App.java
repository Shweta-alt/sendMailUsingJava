package org.geekster;

//import sun.security.util.Password;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("preparing to send message");
        String message = "HEllo, this is for security check ";
        String subject = "Learning java mail api via meaven project";
        String to = "shwetarao7237@gmail.com";
        String from = "jayaun1711@gmail.com";

        sendEmail(message,subject,to,from);
    }

    public static void sendEmail(String message, String subject, String to, String from){
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES" + properties);

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port",465);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth","true");

        properties.put("mail.imap.host",host);
        properties.put("mail.imap.port", 993);
        properties.put("mail.imap.ssl.enable","true");
        properties.put("mail.imap.auth","true");
       Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jayaun1711@gmail.com", "hyneeseskdcvx");
            }
        });

//        Session session;
//        session = null;
        session.setDebug(true);

        MimeMessage m = new MimeMessage(session);
        try{
            m.setFrom(from);

            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            m.setSubject(subject);

            m.setText(message);

            Transport.send(m);

            System.out.print("Sent Successfully");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
