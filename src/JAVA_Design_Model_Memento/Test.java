package JAVA_Design_Model_Memento;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����ԭʼ��  
        Original origi = new Original("egg");  
  
        // ��������¼  
        Storage storage = new Storage(origi.createMemento());  
  
        // �޸�ԭʼ���״̬  
        System.out.println("��ʼ��״̬Ϊ��" + origi.getValue());  
        origi.setValue("niu");  
        System.out.println("�޸ĺ��״̬Ϊ��" + origi.getValue());  
  
        // �ظ�ԭʼ���״̬  
        origi.restoreMemento(storage.getMemento());  
        System.out.println("�ָ����״̬Ϊ��" + origi.getValue());  
	}

}
