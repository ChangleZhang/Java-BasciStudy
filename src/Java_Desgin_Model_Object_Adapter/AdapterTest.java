package Java_Desgin_Model_Object_Adapter;

public class AdapterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Source source = new Source();  
        Targetable target = new Wrapper(source);  
        target.method1();  
        target.method2(); 
	}

}
