package JAVA_Design_Model_Decorator;

public class Decorator implements Sourceable {
		/*
		 * ���д���չ���ʵ��
		 */
		private Sourceable source;  
	      
	    public Decorator(Sourceable source){  
	        super();  
	        this.source = source;  
	    }  
	    @Override  
	    public void method() {  
	        System.out.println("before decorator!");  
	        source.method();  
	        System.out.println("after decorator!");  
	    }  

}
