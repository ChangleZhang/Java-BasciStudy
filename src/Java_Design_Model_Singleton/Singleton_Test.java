package Java_Design_Model_Singleton;

public class Singleton_Test {
	private static Singleton_Test instance = null;  
	  
    private Singleton_Test() {  
    }  
  /*
   * 因为我们只需要在创建类的时候进行同步，所以只要将创建和getInstance()分开，单独为创建加synchronized关键字，也是可以的
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
