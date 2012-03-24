package jesper.edwin;

public class Console extends GameObject {
	
	public boolean isOn = false;
	public String input = "";
	public String output = "";
	private int outputLines = 0;
	private int outputMaxLines = 6;
	private final int NEWLINE = 10;
	
	public enum Command{
		test, shit
	}
	
	public Console(){

	}
	
	public void enterConsole(){
		isOn = true;
		PlattformMP.PAUSE = true;
		
	}
	
	public void closeConsole(boolean sendInfo){
		if(sendInfo) executeCommand(input);
		input = "";
		isOn = false;
		PlattformMP.PAUSE = false;
	}
	
	public void outputConsole(String str){
		if(outputLines<outputMaxLines)
			outputLines++;
		else
			output = output.substring(output.indexOf((char)NEWLINE)+1);
		
		output += str + ((char)NEWLINE);
	}
	
	public void executeCommand(String str){
		if(str!=""){
			outputConsole("> "+str);
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
	
	
	public boolean stringEqualsCommand(String str){
		for (Command me : Command.values()) {
			if (me.name().equalsIgnoreCase(str))
				return true;
		}
		return false;
    }
}
