/**
 * 
 */
package jesper.edwin;

import java.util.*;
import org.newdawn.slick.Graphics;
/**
 * @author Jesper Fridefors
 *
 */
public abstract class Renderable extends GameObject {
	
	static List<Renderable> list = new ArrayList<Renderable>();
	int depth = 0;
	
	public abstract void render(Graphics g);
	
	public Renderable(){
		list.add(this);
	}
	
	
	
}
