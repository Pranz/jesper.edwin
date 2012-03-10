package jesper.edwin;

import java.util.List;
import java.util.ArrayList;

public class GameObject {
	
	static List<GameObject> list = new ArrayList<GameObject>();
	
	public GameObject(){
		list.add(this);
	}

}
