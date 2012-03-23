package jesper.edwin;

import java.util.List;
import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

/*
 * Any interactive object. Has collision
 * and is checked every update.
 */

public class InteractiveObject extends VisualObject {
	
	boolean solid = false;
	
	Rectangle hitbox;
	static List<InteractiveObject> list = new ArrayList<InteractiveObject>();

	public InteractiveObject(double x, double y, Image image) {
		super(x, y, image);
		hitbox = new Rectangle((float)x, (float)y, (float)image.getWidth(), (float)image.getHeight());
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
	
	public boolean collidesWithObject(InteractiveObject object, Rectangle hitbox){
		return(hitbox.intersects(object.hitbox));
	}
	
	public boolean collidesWithObject(List<InteractiveObject> objectList, Rectangle hitbox){
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
	
	public boolean placeMeeting(double x, double y, List<InteractiveObject> objectList){
		return collidesWithObject(objectList, new Rectangle((float)x, (float)y,  hitbox.getWidth(), hitbox.getHeight()));
	}
	

}
