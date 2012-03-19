package jesper.edwin;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.*;

public class Entity extends VisualObject {
	
	Image image;
	boolean organic;
	double gravity = 0.2;
	double hspeed = 5;
	double vspeed = 0;
	double speed = 0.3;
	double friction = 0.2;
	double maxSpeed = 5;
	double maxFallSpeed = 5;
	
	static List<Entity> list = new ArrayList<Entity>();
	
	public Entity(int x, int y, Image image){
		super(x, y, image);
		list.add(this);
		organic = false;
	}
	
	public Entity(int x, int y, Image image, boolean organ){
		super(x, y, image);
		list.add(this);
		organic = organ;
	}
	
	@Override public void update(){
		super.update();
		move(hspeed, vspeed);
		hspeed = increaseNumberTo(hspeed, friction, 0);
	}
	
	@Override public void destroy(){
		super.destroy();
		list.remove(this);
	}
	
	public void walk(double direction){
		//direction is either 1 for right, -1 for left
		hspeed = increaseNumberTo(hspeed, speed, maxSpeed*direction);
	}

}
