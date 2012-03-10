package jesper.edwin;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.*;

public class VisualObject extends GameObject {
	
	Image image;
	
	static List<VisualObject> list = new ArrayList<VisualObject>();
	
	public VisualObject(Image image, double x, double y){
		super(x, y);
		list.add(this);
		this.image = image;
	}

}
