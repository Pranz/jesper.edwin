package jesper.edwin;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;

public class BasicCreature extends Entity {
	
	Alarm mainAttackAlarm = new Alarm(-1, this);
	static List<BasicCreature> list = new ArrayList<BasicCreature>();

	public BasicCreature(int x, int y, Image image) {
		super(x, y, image, true);
		list.add(this);
	}
	
	@Override public void mainAttack(){
		
	}



}
