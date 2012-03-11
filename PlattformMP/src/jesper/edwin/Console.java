package jesper.edwin;



public class Console {
	
	public static boolean isOn = false;
	public static String input = "";
	public static String output = "";
	private static int outputLines = 0;
	private static int outputMaxLines = 6;
	private final static int SPACE = 10;
	
	public enum Command{
		test, shit
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
	
	public static void outputConsole(String str){
		if(outputLines<outputMaxLines)
			outputLines++;
		else
			output=output.substring(output.indexOf((char)10)+1);
		
		output += str + ((char)SPACE);
	}
	
	public static void executeCommand(String str){
		if(str!=""){
			outputConsole(">>"+str);
			String[] command = str.split(" ");
			if(stringEqualsCommand(command[0].toLowerCase())){
				
				switch(Command.valueOf(command[0])){
					case test:
						String _str="";
						for(int i=0;i<command.length;i++)
							_str+="["+i+"]="+command[i]+"; ";
						outputConsole(_str);
						break;
						
					case shit:
						outputConsole("Yes shit");
						break;
				}
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
