package jesper.edwin; 

import org.newdawn.slick.BasicGame; 
import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.Graphics; 
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException; 
import org.newdawn.slick.AppGameContainer; 


public class PlattformMP extends BasicGame { 
	public PlattformMP() { 
		super("PlattformMP"); 
		} 
	
	@Override public void init(GameContainer container) throws SlickException {
		new VisualObject(new Image(System.getProperty("user.dir") + "/resources/image/player.png"), 140, 70);
		
	} 
	
	@Override public void update(GameContainer container, int delta) throws SlickException {
		
	} 
	
	@Override public void render(GameContainer container, Graphics g) throws SlickException { 
		g.drawString("GameObject: " + GameObject.list.size(), 0, 100); 
		g.drawString("VisualObject: " + VisualObject.list.size(), 0, 120); 
		//tog bort all onödig skit för tillfället
		
		//kod som ritar ut alla VisualObject.
		for(VisualObject o : VisualObject.list){
			g.drawImage(o.image, (int)(o.x), (int)(o.y));
		}
	} 
	
	
	public static void main(String[] args) { 
		try { 
			AppGameContainer app = new AppGameContainer(new PlattformMP()); app.start();
			} 
		catch (SlickException e) { 
			e.printStackTrace(); } 
		} 
	}