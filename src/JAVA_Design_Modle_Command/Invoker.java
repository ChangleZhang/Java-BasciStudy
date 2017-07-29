package JAVA_Design_Modle_Command;

public class Invoker {
	private Command command;  
    
    public Invoker(Command command) {  
        this.command = command;  
    }  
  
    public void action(){  
        command.exe();  
    }
}
