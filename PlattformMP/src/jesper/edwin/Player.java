package jesper.edwin;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.*;

public class Player extends GameObject {
	
	int[] key;
	int playerID;
	Entity ent;
	
	//all dem keys
	public enum Key{
		jump, action, up, down, left, right
	}
	static List<Player> list = new ArrayList<Player>();

	
	public Player(Entity ent, int playerID){
		super();
		this.ent = ent;
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
	}
	
	
	protected void handleInput(GameContainer container){
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			ent.walk(LEFT);
		}
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			ent.walk(RIGHT);
		}
		
		if(input.isKeyDown(Input.KEY_DOWN)){
			
		}
		
		if(input.isKeyDown(Input.KEY_UP)){
			
		}
	}
	

}
