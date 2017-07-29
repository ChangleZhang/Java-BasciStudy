package JAVA_Design_Model_Iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection collection = new MyCollection();
		Iterator It = collection.iterator();
		while(It.hasNext()){
			System.out.println(It.next());
		}
		
	}

}
