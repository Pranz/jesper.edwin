package jesper.edwin;

import java.util.List;
import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.*;

/*
 * Any interactive object. Has collision
 * and is checked every update.
 */

public abstract class InteractiveObject extends VisualObject {
	
	boolean solid = false;
	
	Shape hitbox;
	static List<InteractiveObject> list = new ArrayList<InteractiveObject>();

	public InteractiveObject(double x, double y, Image image) {
		super(x, y, image);
		list.add(this);

		

	}
	
	@Override public void update(){
		super.update();
		hitbox.setLocation((float)x, (float)y);
	}
	
	@Override public void destroy(){
		super.destroy();
		list.remove(this);
	}
	
	public boolean collidesWithObject(InteractiveObject object, Shape hitbox){
		return(hitbox.intersects(object.hitbox));
	}
	
	public boolean collidesWithObject(List<? extends InteractiveObject> objectList, Shape hitbox){
		if(objectList.contains(this))objectList.remove(this);
		
		for(InteractiveObject object : objectList){
			if(hitbox.intersects(object.hitbox))return true;
		}
		
		return false;
	}
	
	public void move(double xspeed, double yspeed){
		if(!placeMeeting(x + xspeed, this.y, InteractiveObject.list)){
			this.x += xspeed;
			this.y += yspeed;
		}

	}
	
	public boolean placeMeeting(double x, double y, List<? extends InteractiveObject> objectList){
		return collidesWithObject(objectList, new Rectangle((float)x, (float)y,  hitbox.getWidth(), hitbox.getHeight()));
	}
	
	public List<? extends InteractiveObject> getCollidedObjects(List<? extends InteractiveObject> typeList){
		
		List<InteractiveObject> l = new ArrayList<InteractiveObject>();
		if(typeList.contains(this))typeList.remove(this);
		
		for(InteractiveObject object : typeList){
			if(hitbox.intersects(object.hitbox))l.add(object);
		}
		
		return l;
	}

}
