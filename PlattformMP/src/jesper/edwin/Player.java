package jesper.edwin;

import org.newdawn.slick.*;

public class Player extends Entity {
	
	int[] key;
	int playerID;
	// TODO fill key[actionkey, eg JUMP_BUTTON] with values got from a config file. It should be based on the player ID, 
	// i.e PlayerID 1 gets player1.config
	
	public Player(int x, int y, Image image, int playerID){
		super(x, y, image);
	}
	

}
