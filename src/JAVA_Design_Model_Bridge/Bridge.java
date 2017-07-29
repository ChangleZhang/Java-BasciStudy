package JAVA_Design_Model_Bridge;
/*
 * 定义一个桥，它持有Sourceable的一个类
 */
public abstract class Bridge {
	private Sourceable source;  
	  
    public void method(){  
        source.method();  
    }  
      
    public Sourceable getSource() {  
        return source;  
    }  
  
    public void setSource(Sourceable source) {  
        this.source = source;  
    }  
}
