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
		
		if(PlattformMP.console.isOn){
			if((key == Input.KEY_SPACE) || (c >= ' '))PlattformMP.console.input += c;
			if(key == Input.KEY_BACK && PlattformMP.console.input.length() > 0){
				PlattformMP.console.input = PlattformMP.console.input.substring(0, PlattformMP.console.input.length()-1);
			}
		}
		else{
			//Normal keyboard input go here
			
			//Pauses when player presses 'p'
			if( c == 'p') PlattformMP.PAUSE = !PlattformMP.PAUSE;
		}
		if(key == Input.KEY_ENTER){
			if(!PlattformMP.console.isOn) PlattformMP.console.enterConsole();
			else PlattformMP.console.closeConsole(true);
		}
		
		

	}

	
	@Override
	public void keyReleased(int key, char c) {

	}

}
