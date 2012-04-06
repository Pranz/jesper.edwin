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
public interface Renderable {
	
	static List<Renderable> list = new ArrayList<Renderable>();
	
	public void render(Graphics g);
	
}
