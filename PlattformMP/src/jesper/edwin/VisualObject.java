package jesper.edwin;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.*;

public class VisualObject extends GameObject {
	
	Image image;
	double x;
	double y;
	int alarmNumber = super.alarmNumber;
	
	static List<VisualObject> list = new ArrayList<VisualObject>();
	
	public VisualObject(double x, double y, Image image){
		super();
		list.add(this);
		this.image = image;
		this.x = x;
		this.y = y;
		new Alarm(super.alarmNumber+1, 120, this);
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
	
	public void callAlarm(int number, Alarm alarm){
		//if(number == super.alarmNumber+1)System.out.println("Ypy");
	}
	

}
