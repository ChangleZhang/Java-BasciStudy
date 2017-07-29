package JAVA_Design_Model_Strategy;

public class StrategyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "2+8";  
        ICalculator cal = new Plus();  
        int result = cal.calculate(exp);  
        System.out.println(result);  
	}

}
