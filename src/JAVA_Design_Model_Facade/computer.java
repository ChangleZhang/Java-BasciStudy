package JAVA_Design_Model_Facade;

public class computer {
	private  cpu CPU;  
    private  memory Memory;  
    private  disk Disk;  
      
    public computer(){  
    	CPU = new cpu();  
        Memory = new memory();  
        Disk = new disk();  
    }  
      
    public void startup(){  
        System.out.println("start the computer!");  
        CPU.startup();  
        Memory.startup();  
        Disk.startup();  
        System.out.println("start computer finished!");  
    }  
      
    public void shutdown(){  
        System.out.println("begin to close the computer!");  
        CPU.shutdown();  
        Memory.shutdown();  
        Disk.shutdown();  
        System.out.println("computer closed!");  
    }  
}
