package JAVA_Design_Model_FactoryModel;

public class FactoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ���ù����е�produce���������ݲ���sms���ɹ���������������Senderʵ��
		 */
		SendFactory1 factory = new SendFactory1();  
        Sender sender = factory.produce("sms");  
        sender.Send();  
        /*
         * ���ö๤������ģʽ�е�produceMail()����������������ݣ����ɴ�������
         */
        SendFactory2 factory2 = new SendFactory2();
        Sender sender2 = factory2.produceMail();
        sender2.Send();
        /*
         * ���þ�̬��������ģʽ��ֱ��ͨ����̬��������ʵ��
         */
        Sender sender3 = SendFactory3.produceSms();
        sender3.Send();
	}

}
