package JAVA_Design_Model_Strategy;

public class Plus extends AbstractCalculator implements ICalculator {

	@Override
	public int calculate(String exp) {
		// TODO Auto-generated method stub
		int arrayInt[] = split(exp,"\\+");  
        return arrayInt[0]+arrayInt[1];  
	}

}
