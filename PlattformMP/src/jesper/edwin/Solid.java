package jesper.edwin;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Solid extends Terrain {
	
	static List<Solid> list = new ArrayList<Solid>();
	boolean solid = true;

	public Solid(double x, double y, Image image) {
		super(x, y, image);
		list.add(this);
	}
	
	@Override public void render(Graphics g){
		g.drawImage(image, Math.round(x), Math.round(y));
	}

}
