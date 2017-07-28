package JAVA_Design_Model_Prototype;

public class Prototype implements Cloneable {
	public Object clone() throws CloneNotSupportedException {  
        Prototype proto = (Prototype) super.clone();  
        return proto;  
    }  
}
