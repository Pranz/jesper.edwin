package jesper.edwin;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Console extends Renderable{
	
	public boolean isOn = false;
	public String input = "";
	public String output = "";
	private int outputLines = 0;
	private int outputMaxLines = 6;
	private final int NEWLINE = 10;
	Alarm consoleTimer=new Alarm(240,this);
	
	public enum Command{
		test, shit
	}
	
	public Console(){
		depth = 10;
	}
	
	@Override public void render(Graphics g){
		if(isOn||consoleTimer.ticks<consoleTimer.maxTicks){
			int alpha=255;
			if(consoleTimer.ticks<consoleTimer.maxTicks)
				alpha=255-((int)(((float)consoleTimer.ticks/consoleTimer.maxTicks)*255));
			//TODO Göra till List istället för array
			String[] consoleOut = output.split(Character.toString((char)10));
			for(int i = 0; i < consoleOut.length; i++){
				g.setColor(new Color(0,0,0,alpha));
				g.drawString(consoleOut[i], 6+2, PlattformMP.WINDOW_HEIGHT - 20- ((consoleOut.length-i) * 20)+2);
				g.drawString(consoleOut[i], 6-2, PlattformMP.WINDOW_HEIGHT - 20- ((consoleOut.length-i) * 20)-2);
				g.setColor(new Color(255,255,255,alpha));
				g.drawString(consoleOut[i], 6, PlattformMP.WINDOW_HEIGHT - 20- ((consoleOut.length-i) * 20));
				g.setColor(Color.white);
			}
		}
		if(isOn){
			g.setColor(Color.darkGray);
			g.fillRect(0,PlattformMP.WINDOW_HEIGHT-20,PlattformMP.WINDOW_WIDTH,PlattformMP.WINDOW_HEIGHT);
			g.setColor(Color.white);
			g.drawString("> " + input, 6, PlattformMP.WINDOW_HEIGHT-20);
			g.drawLine(26+input.length()*9, PlattformMP.WINDOW_HEIGHT-20+2, 26+input.length()*9, PlattformMP.WINDOW_HEIGHT-2);
		}
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
		consoleTimer=consoleTimer.loop();
	}
	
	public void executeCommand(String str){
		if(str!=""){
			outputConsole("> "+str);
			String[] command = str.split(" ");
			command[0]=command[0].toLowerCase();
			if(stringEqualsCommand(command[0])){
				
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
