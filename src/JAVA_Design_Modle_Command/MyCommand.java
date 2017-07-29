package JAVA_Design_Modle_Command;

public class MyCommand implements Command {

	private Receiver receiver;  
    
    public MyCommand(Receiver receiver) {  
        this.receiver = receiver;  
    }  
  
    @Override  
    public void exe() {  
        receiver.action();  
    }  

}
