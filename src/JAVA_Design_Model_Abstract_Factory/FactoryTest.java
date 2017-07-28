package JAVA_Design_Model_Abstract_Factory;

public class FactoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.Send();
	}

}
