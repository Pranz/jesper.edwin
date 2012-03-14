package jesper.edwin;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.*;

public class Entity extends VisualObject {
	
	Image image;
	boolean organic;
	
	
	static List<Entity> list = new ArrayList<Entity>();
	
	public Entity(int x, int y, Image image){
		super(x, y, image);
		organic = false;
	}
	
	public Entity(int x, int y, Image image, boolean organ){
		super(x, y, image);
		organic = organ;
	}
	
	@Override public void update(){
		super.update();
	}
	
	@Override public void destroy(){
		super.destroy();
	}

}
