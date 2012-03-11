package jesper.edwin;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.*;

public class VisualObject extends GameObject {
	
	Image image;
	double x;
	double y;
	int alarmNumber = super.alarmNumber+1;
	
	static List<VisualObject> list = new ArrayList<VisualObject>();
	
	public VisualObject(Image image, double x, double y){
		super();
		list.add(this);
		this.image = image;
		this.x = x;
		this.y = y;
		new Alarm(super.alarmNumber, 200, this);
		new Alarm(super.alarmNumber + 1, 200, this);
	}
	
	public void move(int x, int y){
		this.x += x;
		this.y += y;
	}
	
	@Override public void callAlarm(int number, Alarm alarm){
		super.callAlarm(number, alarm);
		if(number - super.alarmNumber == 0){
			System.out.println("Success");
			//alarm.loop();
		}
		if(number - super.alarmNumber == 1){
			System.out.println("Testing shit yo");
		}
	}
	
	@Override public void destroy(){
		super.destroy();
		list.remove(this);
	}
	

}
