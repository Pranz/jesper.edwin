package jesper.edwin;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.*;

public class VisualObject extends GameObject {
	
	Image image;
	double x;
	double y;
	
	static List<VisualObject> list = new ArrayList<VisualObject>();
	
	public VisualObject(Image image, double x, double y){
		super();
		list.add(this);
		this.image = image;
		this.x = x;
		this.y = y;
		new Alarm(0, 200, this);
	}
	
	public void move(int x, int y){
		this.x += x;
		this.y += y;
	}
	
	@Override public void callAlarm(int number, Alarm alarm){
		if(number == 0){
			System.out.println("Success");
			alarm.loop();
		}
	}
	
	@Override public void destroy(){
		super.destroy();
		list.remove(this);
	}
	

}
