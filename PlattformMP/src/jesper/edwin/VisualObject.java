package jesper.edwin;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.*;

public class VisualObject extends GameObject {
	
	Image image;
	double x;
	double y;
	Alarm testAlarm;
	Alarm secondAlarm;
	
	static List<VisualObject> list = new ArrayList<VisualObject>();
	
	public VisualObject(double x, double y, Image image){
		super();
		list.add(this);
		this.image = image;
		this.x = x;
		this.y = y;
		testAlarm = new Alarm(120, this);
		secondAlarm = new Alarm(200, this);
		
	}
	
	public void move(double xspeed, double yspeed){
		this.x += xspeed;
		this.y += yspeed;
	}
	
	@Override public void destroy(){
		super.destroy();
		list.remove(this);
	}
	
	@Override public void update(){
		super.update();
	}
	
	public void callAlarm(Alarm alarm){
		/*
		 * Examples for alarms, I'll leave them here
		if(alarm == testAlarm){
			System.out.println("Ypy");
			testAlarm = alarm.loop();
		}
		if(alarm == secondAlarm)System.out.println("Yoyoyo");
		*/
	}
	

}
