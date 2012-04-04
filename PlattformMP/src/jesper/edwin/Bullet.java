package jesper.edwin;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;

/*
 * PROJECTILE?
 * ^ Allting kommer fungera som en projektil, även stillbild av t.ex ett svärd. 
 * Any sword, bullet or object that cause damage go into this class
 */

public class Bullet extends InteractiveObject {
	
	List<Bullet> list = new ArrayList<Bullet>();

	public Bullet(double x, double y, Image image) {
		super(x, y, image);
		list.add(this);
	}

}
