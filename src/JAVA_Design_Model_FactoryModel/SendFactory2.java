package JAVA_Design_Model_FactoryModel;

public class SendFactory2 {
	public Sender produceMail(){
		return new MailSender();
	}
	
	public Sender produceSms(){
		return new SmsSender();
	}
}
