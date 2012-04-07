package jesper.edwin;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.*;

public class Terrain extends InteractiveObject {
	
	static List<Terrain> list = new ArrayList<Terrain>();
	
	boolean walkable = true;
	boolean solid = true;
	double angle = 0;
	
	public Terrain(double x, double y, Image image){
		super(x, y, image);
		list.add(this);
	}

}