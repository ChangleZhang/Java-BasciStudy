package JAVA_Design_Method_State;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 State state = new State();  
	     Context context = new Context(state);  
	          
	     //���õ�һ��״̬  
	     state.setValue("state1");  
	     context.method();  
	          
	     //���õڶ���״̬  
	     state.setValue("state2");  
	     context.method();
	}

}
