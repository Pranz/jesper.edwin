package jesper.edwin;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.*;

public class Player extends Entity {
	
	int[] key;
	int playerID;
	
	//all dem keys
	public enum Key{
		jumpKey, actionKey, upKey, downKey, leftKey, rightKey
	}
	static List<Player> list = new ArrayList<Player>();

	
	public Player(int x, int y, Image image, int playerID){
		super(x, y, image);
		list.add(this);
		defineKeys();
	}
	
	protected void defineKeys(){
		// TODO fill key[eg jumpKey] with values got from a config file. It should be based on the player ID, 
		// i.e PlayerID 1 gets player1.config
	}
	
	@Override public void update(){
		super.update();
		handleInput(PlattformMP.globalContainer);
	}
	
	@Override public void destroy(){
		super.destroy();
		list.remove(this);
		handleInput(PlattformMP.globalContainer);
	}
	
	
	protected void handleInput(GameContainer container){
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			move(-2, 0);
		}
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			move(2, 0);
		}
		
		if(input.isKeyDown(Input.KEY_DOWN)){
			move(0, 2);
		}
		
		if(input.isKeyDown(Input.KEY_UP)){
			move(0, -2);
		}
	}
	

}
