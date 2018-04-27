import java.util.Random;

public class Example {
	
	// ignore ARRAY variable below
	private static final String[] ARRAY = {
			"Patron 1: I eat at a different restaurant every day. Patron 2: I don't tip, either.",
			"Did you hear about the new restaurant on the moon? Great food but no atmosphere.",
			"How many cafeteria staff does it take to change a light bulb? \"Sorry, we closed 18 seconds ago, and I've just cashed up.\"",
			"How many McDonald's counter girls does it take to change a light bulb? Two. One to change it and one to put some chips with it.",
			"Why was the restaurant called \"Out of this World\"? Because it was full of Unidentified Frying Objects.",
			"Jane's father decided to take all the family out to a restaurant for a meal. As he spent quite a lot of money for the meal he said to the waiter, \"Could I have a bag to take the leftovers home for the dog?\" \"Gosh!\" exclaimed Jane, \"Are we getting a dog?\"",
	};

	/**
	 * Basically need to call three code lines mentioned below to send a mail.
	 * Copy these code lines to a place where you need to send an email.
	 * include System.out.println("the message"); anywhere to print message to console  
	 */
	public static void run() {
		/* 
		 * set up account in the same way as below.
		 * first argument is string value of mail address of the APP : has to be gmail
		 * second argument is string value of the password for the gmail account
		 */
		Account account = new Account("resapp22@gmail.com", "resapp@22!");
		
		/*
		 * Set up email content in a similar was as show below
		 * first argument: recipient email address
		 * second argument: Subject line of the email
		 * third argument: string message of the eamil
		 * 
		 * e.g.: Content content = new Content("avirdi.pb@gmail.com", "Welcome New Customer !!", "This is the body of the eamil");
		 * 
		 * Also, getRandom() in line below just processes into a string like "This is the body of the eamil"
		 * 
		 */
		Content content = new Content("avirdi.pb@gmail.com", "Welcome New Customer !!", getRandom());  
		
		
		/*
		 * use GamilOverSSL.send to send the email configured above.
		 * first argument: account that us configured above
		 * second argument: content of the email that was configured above.
		 */
		GmailOverSSL.send(account, content);
	}
	public static void main(String[] args) {
		run();
	}
	
	private static String getRandom() {
	    int rnd = new Random().nextInt(ARRAY.length);
	    return ARRAY[rnd];
	}
}
