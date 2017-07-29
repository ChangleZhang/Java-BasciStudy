package JAVA_Design_Method_State;
/** 
 * 状态类的核心类 
 * 2017-07-29
 * @author challen 
 * 
 */  
public class State {
	private String value;  
    
    public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value;  
    }  
  
    public void method1(){  
        System.out.println("execute the first opt!");  
    }  
      
    public void method2(){  
        System.out.println("execute the second opt!");  
    }  
}
