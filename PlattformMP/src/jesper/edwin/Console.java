package jesper.edwin;



public class Console {
	
	public static boolean isOn = false;
	public static String input = "";
	
	public enum Command{
		getdemand, getsupply
	}
	
	public Console(){

	}
	
	public static void enterConsole(){
		isOn = true;
		PlattformMP.PAUSE = true;
		
	}
	
	public static void closeConsole(boolean sendInfo){
		if(sendInfo) executeCommand(input);
		input = "";
		isOn = false;
		PlattformMP.PAUSE = false;
	}
	
	public static void executeCommand(String str){
		String[] command = str.split(" ");
		if(stringEqualsCommand(command[0].toLowerCase())){
			
			switch(Command.valueOf(command[0])){
				
			case getdemand:

			
			}
		}
		
	}
	
	
	public static boolean stringEqualsCommand(String str){
		for (Command me : Command.values()) {
			if (me.name().equalsIgnoreCase(str))
				return true;
		}
		return false;
    }

}
