package jesper.edwin;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Entity extends InteractiveObject {
	
	Image image;
	boolean organic;
	double gravity = 0.42;
	double hspeed = 0;
	double vspeed = 0;
	double speed = 0.5;
	double friction = 0.3;
	double maxSpeed = 3.5;
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
		
		//TODO Pixel-perfect move fixat med decimaler tror jag, kolla ifall det stämmer. Speed jiggling när man kolliderar igen
		int xdir = signum(xspeed),i=0;
		for(i=0;i<Math.abs(floorTo0(xspeed));i++){
			if(!placeMeeting(floorTo0(x+xdir),y,InteractiveObject.list))
				this.x+=xdir;
			else{
				hspeed=0;
				break;
			}
		}
		if(i>=Math.abs(floorTo0(xspeed))){
		
			double xdecimals=(Math.abs(xspeed)-Math.abs(floorTo0(xspeed)))*xdir;
			if(!placeMeeting(x+xdecimals,y,InteractiveObject.list)){
				this.x+=xdecimals;
				//Går ej att göra detta, antagligen för att alla objekt är oexakta och ligger på runt t.ex. x=5.000000001 
				//och då funkar ej collision check när dentta objekt står på x=5.0
				//if(xdir==1)this.x=floorTo0(this.x);else this.x = ceilTo0(this.x);
			}

		}
		
		int ydir = signum(yspeed);
		for(i=0;i<Math.abs(floorTo0(yspeed));i++){
			if(!placeMeeting(x,floorTo0(y+ydir),InteractiveObject.list))
				this.y+=ydir;
			else{
				vspeed=0;
				break;
			}
		}
		if(i>=Math.abs(floorTo0(yspeed))){
			double ydecimals=(Math.abs(yspeed)-Math.abs(floorTo0(yspeed)))*ydir;
			if(!placeMeeting(x,y+ydecimals,InteractiveObject.list))
				this.y+=ydecimals;
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
