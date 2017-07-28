package Java_Design_Model_Singleton;

public class Singleton_Test {
	private static Singleton_Test instance = null;  
	  
    private Singleton_Test() {  
    }  
  /*
   * ��Ϊ����ֻ��Ҫ�ڴ������ʱ�����ͬ��������ֻҪ��������getInstance()�ֿ�������Ϊ������synchronized�ؼ��֣�Ҳ�ǿ��Ե�
   */
    private static synchronized void syncInit() {  
        if (instance == null) {  
            instance = new Singleton_Test();  
        }  
    }  
  
    public static Singleton_Test getInstance() {  
        if (instance == null) {  
            syncInit();  
        }  
        return instance;  
    }  
}
