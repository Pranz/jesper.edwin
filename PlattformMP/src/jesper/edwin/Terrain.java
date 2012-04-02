package jesper.edwin;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Terrain extends InteractiveObject {
	
	static List<Terrain> list = new ArrayList<Terrain>();
	
	boolean walkable = true;
	boolean solid = true;
	
	public Terrain(double x, double y, Image image){
		super(x, y, image);
		list.add(this);
	}

}
