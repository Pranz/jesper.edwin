package jesper.edwin;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

public class Mouse implements MouseListener{
	
	public Mouse(){
		
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
	public void mouseWheelMoved(int change) {
		PlattformMP.console.outputConsole("Mouse Wheel: "+change);
		
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		PlattformMP.console.outputConsole("Mouse Pressed: "+button);
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		PlattformMP.console.outputConsole("Mouse Released: "+button);
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		
	}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		
	}
}
