package JAVA_Design_Model_Class_Adapter;

public class AdapterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Targetable target = new Adapter();
		target.method1();
		target.method2();
	}

}
