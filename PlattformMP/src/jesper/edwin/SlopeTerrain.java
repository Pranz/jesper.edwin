/**
 * 
 */
package jesper.edwin;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;

/**
 *
 *
 */
public class SlopeTerrain extends Terrain {
	
	static List<SlopeTerrain> list = new ArrayList<SlopeTerrain>();
	
	public SlopeTerrain(double x, double y, Image image){
		super(x, y, image);
		list.add(this);
		hitbox = new Polygon(new float[]{
				(float)x, (float)(y + image.getHeight()),
				(float)x + image.getWidth(), (float)y + image.getHeight(),
				(float)x + image.getWidth(), (float)y
		});
	}

}
