public class Content {
	private String recipient;
	private String subject;
	private String body;
	
	public Content(String recipient, String subject, String message) {
		super();
		this.recipient = recipient;
		this.subject = subject;
		this.body = message;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecepient(String recipient) {
		this.recipient = recipient;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return body;
	}
	public void setMessage(String message) {
		this.body = message;
	}
	@Override
	public String toString() {
		return "Mesasge [recipient=" + recipient + ", subject=" + subject + ", message=" + body + "]";
	}
}
