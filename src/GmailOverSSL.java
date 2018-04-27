import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailOverSSL {
	
	private static Properties props = new Properties();
	
	private static Account account;
	private static Content content;
	
	
	public static void send(Account f_account, Content f_content) {
		account = f_account;
		content = f_content;
		setProperties();
		run();
	}
	
	private static void run() {

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(
								account.getMailId(), account.getPassword()
							);
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(account.getMailId()));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(content.getRecipient()));
			message.setSubject(content.getSubject());
			message.setText(content.getMessage());

			Transport.send(message);

			System.out.println("Email Sent Successfully !!");
			System.out.println("Recipient: ["+ content.getRecipient()+"]");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void setProperties() {
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
	}
}