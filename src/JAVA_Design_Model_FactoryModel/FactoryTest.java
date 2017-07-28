package JAVA_Design_Model_FactoryModel;

public class FactoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 调用工厂中的produce方法，传递参数sms，由工厂决定创建哪种Sender实例
		 */
		SendFactory1 factory = new SendFactory1();  
        Sender sender = factory.produce("sms");  
        sender.Send();  
        /*
         * 调用多工厂方法模式中的produceMail()方法，无需参数传递，即可创建对象
         */
        SendFactory2 factory2 = new SendFactory2();
        Sender sender2 = factory2.produceMail();
        sender2.Send();
        /*
         * 调用静态工厂方法模式，直接通过静态方法构建实例
         */
        Sender sender3 = SendFactory3.produceSms();
        sender3.Send();
	}

}
