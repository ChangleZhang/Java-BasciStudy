package JAVA_Design_Model_Class_Adapter;

public class Adapter extends Source implements Targetable {

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("This is a Targetable Method!");
	}

}
