package JAVA_Design_Model_FactoryModel;

public class SendFactory3 {
	public static Sender produceMail(){
		return new MailSender();
	}
	
	public static Sender produceSms(){
		return new SmsSender();
	}
}
