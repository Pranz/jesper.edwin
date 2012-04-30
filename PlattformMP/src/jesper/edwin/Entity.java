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
	double maxSpeed = 7;
	double maxFallSpeed = 5;
	boolean solid = true;
	double jumpStrength = 14;
	int stepSize = 4;
	double height = 0;
	double prvHeight = 0;
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
		vspeed += gravity;
		move(hspeed, vspeed);
		hspeed = increaseNumberTo(hspeed, friction, 0);

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
		//TODO Pixel-perfect moving kanske uppstår problem vid längre sträckor, en risk. Får testa senare
		//X-movement, horizontal
		int xdir = signum(xspeed);
		double i;

		for(i=0;i<Math.abs(floorTo0(xspeed));i++){
			height = getHeightDifference(xdir);
			//if(height != prvHeight)System.out.println(""+height); debug
			prvHeight = height;
			if(Math.abs(height) < stepSize){ 
				y += height;
				x += xdir;
				if(height < 0)i += Math.abs(height)*(SQRT_2 - 1);
						
			}
			else{
				hspeed=0; //...sätt hspeed=0 och avbryt for-loop i förväg			
				break;
			}

		}
	
		double xdecimals=(Math.abs(xspeed)-Math.abs(floorTo0(xspeed)))*xdir;
		if(i>=Math.abs(floorTo0(xspeed))){ //Om den har lyckats flytta sig xspeed framåt i heltal då det är fritt xspeed antal pixlar framåt
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
		for(i=0;i<Math.abs(floorTo0(yspeed));i++){ //Kollar om alla positioner inom xspeed framåt är lediga
			if(!placeMeeting(x,y+ydir,Terrain.list)) //Om +1 är det...
				this.y+=ydir; //...så rör den ett framåt
			else{ //...annars
				vspeed=0; //...sätt hspeed=0 och avbryt for-loop i förväg			
				break;
			}
		}
		double ydecimals=(Math.abs(yspeed)-Math.abs(floorTo0(yspeed)))*ydir;
		if(i>=Math.abs(floorTo0(yspeed))){ //Om den har lyckats flytta sig xspeed framåt i heltal då det är fritt xspeed antal pixlar framåt
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
	

	 public double getHeightDifference(int direction){
		 if(!placeMeeting(x + direction, y, Terrain.list))//om man inte träffar någonting bara en pixel framåt
	 	 {
	 	 
		 if(!placeMeeting(x + direction, y + stepSize + 1, Terrain.list)) return 0;//om man befinner sig i luften, returnera 0
		 else{
	 		 for(double i = 0; i < stepSize; i += 0.1){ //annars, gå neråt tills man träffar mark och returnera hur långt ner man gick.
	 			 if(placeMeeting(x + direction, y + i + 1, Terrain.list)) return i;
	 		 }
		 }
	 	 }
	 	 
	 	 //om man träffar något
	 	else for(double i = 0; i < stepSize; i += 0.1){
	 		//gå uppåt tills man inte träffar något.
	 		if(!placeMeeting(x + direction, y - i, Terrain.list)) return -i; 
	 	}
	 	return stepSize + 1;
	}
	
}
