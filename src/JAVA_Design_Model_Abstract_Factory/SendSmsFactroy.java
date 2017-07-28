package JAVA_Design_Model_Abstract_Factory;

public class SendSmsFactroy implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}

}
