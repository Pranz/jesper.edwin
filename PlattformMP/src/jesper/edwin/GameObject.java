package jesper.edwin;

import java.util.List;
import java.util.ArrayList;

public abstract class GameObject {
	
	double x;
	double y;
	
	static List<GameObject> list = new ArrayList<GameObject>();
	
	public GameObject(double x, double y){
		list.add(this);
		this.x = x;
		this.y = y;
	}
	
	public void move(int x, int y){
		this.x += x;
		this.y += y;
	}

}
