package jesper.edwin;


import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class Keyboard implements KeyListener {
	
	public Keyboard(){
		
	}

	@Override
	public void inputEnded() {

	}

	@Override
	public void inputStarted() {

	}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void setInput(Input input) {

	}

	@Override
	public void keyPressed(int key, char c) {
		
		if(Console.isOn){
			if((key == Input.KEY_SPACE) || (c >= ' '))Console.input += c;
			if(key == Input.KEY_BACK && Console.input.length() > 0){
				Console.input = Console.input.substring(0, Console.input.length()-1);
			}
		}
		else{
			//Normal keyboard input go here
			
			//Pauses when player presses 'p'
			if( c == 'p') PlattformMP.PAUSE = !PlattformMP.PAUSE;
		}
		if(key == Input.KEY_ENTER){
			if(!Console.isOn) Console.enterConsole();
			else Console.closeConsole(true);
		}
		
		

	}

	
	@Override
	public void keyReleased(int key, char c) {

	}

}
