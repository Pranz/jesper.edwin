package jesper.edwin;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.*;

public class Entity extends InteractiveObject {
	
	Image image;
	boolean organic;
	double gravity = 0.42;
	double hspeed = 0;
	double vspeed = 0;
	double speed = 1.5;
	double friction = 0.3;
	double maxSpeed = 4;
	double maxFallSpeed = 5;
	boolean solid = true;
	double jumpStrength = 10;
	static List<Entity> list = new ArrayList<Entity>();
	private static final double SQRT_2 = 1.41421;
	
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
		//TODO Pixel-perfect moving kanske uppst�r problem vid l�ngre str�ckor, en risk. F�r testa senare
		//X-movement, horizontal
		int xdir = signum(xspeed),i=0;
		for(i=0;i<Math.abs(floorTo0(xspeed));i++){ //Kollar om alla positioner inom xspeed fram�t �r lediga
			if(!placeMeeting(x+xdir, y, Terrain.list)) //Om +1 �r det...
				this.x+=xdir; //...s� r�r den ett fram�t

			else{ //...annars
				InteractiveObject conflict = getCollidedObject(x+xdir, y, Terrain.list);
				if(!placeMeeting(x+xdir, y-1, conflict)){
					x += xdir/SQRT_2;
					y -= 1/SQRT_2;
				}
				else{
					hspeed=0; //...s�tt hspeed=0 och avbryt for-loop i f�rv�g			
					break;
				}

			}
		}
		double xdecimals=(Math.abs(xspeed)-Math.abs(floorTo0(xspeed)))*xdir;
		if(i>=Math.abs(floorTo0(xspeed))){ //Om den har lyckats flytta sig xspeed fram�t i heltal d� det �r fritt xspeed antal pixlar fram�t
			if(!placeMeeting(x+xdir,y,Terrain.list))
				this.x+=xdecimals;
			else{
				if(xdir==1) 
					this.x=floorTo0(this.x);
				else this.x = ceilTo0(this.x);
				//InteractiveObject conflict = getCollidedObject(x+xdir, y, Terrain.list);
				//hspeed=0;
			}
		}

		//Y-movement, vertical
		int ydir = signum(yspeed);
		for(i=0;i<Math.abs(floorTo0(yspeed));i++){ //Kollar om alla positioner inom xspeed fram�t �r lediga
			if(!placeMeeting(x,y+ydir,Terrain.list)) //Om +1 �r det...
				this.y+=ydir; //...s� r�r den ett fram�t
			else{ //...annars
				vspeed=0; //...s�tt hspeed=0 och avbryt for-loop i f�rv�g			
				break;
			}
		}
		double ydecimals=(Math.abs(yspeed)-Math.abs(floorTo0(yspeed)))*ydir;
		if(i>=Math.abs(floorTo0(yspeed))){ //Om den har lyckats flytta sig xspeed fram�t i heltal d� det �r fritt xspeed antal pixlar fram�t
			if(!placeMeeting(x,y+ydir,Terrain.list))
				this.y+=ydecimals;
			else{
				if(ydir==1)this.y=floorTo0(this.y);else this.y = ceilTo0(this.y);
				vspeed=0;
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
