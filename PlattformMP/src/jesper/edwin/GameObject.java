package jesper.edwin;

import java.util.List;
import java.util.ArrayList;

public abstract class GameObject {
	
	
	static List<GameObject> list = new ArrayList<GameObject>();
	static List<GameObject> removeList = new ArrayList<GameObject>();
	
	public GameObject(){
		list.add(this);
	}

	
	public void update(){
		
	}
	
	public void destroy(){

		removeList.add(this);

	}
	
	public void callAlarm(int number){
		
	}

}
