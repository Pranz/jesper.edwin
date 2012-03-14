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
		//this.x = x;
		//this.y = y;
	}
	
	public void move(int x, int y){
		this.x += x;
		this.y += y;
	}
	
	@Override public void destroy(){
		super.destroy();
		list.remove(this);
	}
	
	@Override public void update(){
		super.update();
	}
	

}
