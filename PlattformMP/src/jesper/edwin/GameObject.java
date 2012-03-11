package jesper.edwin;

import java.util.List;
import java.util.ArrayList;

public abstract class GameObject {
	
	
	static List<GameObject> list = new ArrayList<GameObject>();
	
	public GameObject(){
		list.add(this);
	}

	
	public void update(){
		
	}
	
	public void destroy(){
		list.remove(this);
	}
	
	public void callAlarm(int number, Alarm alarm){
		
	}

}
