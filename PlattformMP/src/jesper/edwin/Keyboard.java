package jesper.edwin;


import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class Keyboard implements KeyListener {
	
	public Keyboard(){
		
	}

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setInput(Input input) {
		// TODO Auto-generated method stub

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
	public void keyReleased(int arg0, char arg1) {
		// TODO Auto-generated method stub

	}

}
