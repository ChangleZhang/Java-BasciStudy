package Java_Desgin_Model_Object_Adapter;

public class Wrapper implements Targetable {

	private Source source;
	
	public Wrapper(Source source){
		super();
		this.source = source;
	}
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("This is Targetable Method!");
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		source.method1();
	}

}
