package jesper.edwin;

import java.util.ArrayList;
import java.util.List;

public class VisualObject extends GameObject {
	
	
	static List<VisualObject> list = new ArrayList<VisualObject>();
	
	public VisualObject(){
		list.add(this);
	}

}
