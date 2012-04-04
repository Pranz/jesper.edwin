package jesper.edwin;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Entity extends InteractiveObject {
	
	Image image;
	boolean organic;
	double gravity = 0.42;
	double hspeed = 4;
	double vspeed = 0;
	double speed = 0.5;
	double friction = 0.3;
	double maxSpeed = 3;
	double maxFallSpeed = 5;
	boolean solid = true;
	double jumpStrength = 10;
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
		vspeed += gravity;
	}
	
	@Override public void destroy(){
		super.destroy();
		list.remove(this);
	}
	
	@Override public void callAlarm(Alarm alarm){
		super.callAlarm(alarm);
	}
	
	public void walk(double direction){
		//direction is either 1 for right, -1 for left
		hspeed = increaseNumberTo(hspeed, speed, maxSpeed*direction);
	}
	
	@Override public void move(double xspeed, double yspeed){
		/*if(!placeMeeting(x + xspeed, y, InteractiveObject.list)){
			this.x += xspeed;
		}
		else hspeed = 0;
		
		if(!placeMeeting(x, y + yspeed, InteractiveObject.list)){
			this.y += yspeed;
		}
		else vspeed = 0;*/
		
		//TODO Pixel-perfect move är bara i int än så länge, inga decimaler, fixar sen
		//Eftersom Entity är en subclass av GameObject behöver du ej skriva GameObject.signum.
		int _x = signum(xspeed);
		for(int i=0;i<Math.abs(xspeed);i++){
			if(!placeMeeting(x+_x,y,InteractiveObject.list))
				this.x+=_x;
			else{
				hspeed=0;
				break;
			}
		}
		
		int _y = signum(yspeed);
		for(int i=0;i<Math.abs(yspeed);i++){
			if(!placeMeeting(x,y+_y,InteractiveObject.list))
				this.y+=_y;
			else{
				vspeed=0;
				break;
			}
		}
	}
	
	public void mainAttack(){
		
	}
	
	public void nullSpeed(){
		hspeed = 0;
		vspeed = 0;
	}
	
	public void setSpeed(double newHspeed, double newVspeed){
		hspeed = newHspeed;
		vspeed = newVspeed;
	}

}
