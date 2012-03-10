package jesper.edwin; 

import org.newdawn.slick.BasicGame; 
import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.Graphics; 
import org.newdawn.slick.SlickException; 
import org.newdawn.slick.AppGameContainer; 


public class PlattformMP extends BasicGame { 
	public PlattformMP() { 
		super("PlattformMP"); 
		} 
	
	@Override public void init(GameContainer container) throws SlickException {
		new GameObject();
		new GameObject();
		new VisualObject();
		
	} 
	
	@Override public void update(GameContainer container, int delta) throws SlickException {
		
	} 
	
	@Override public void render(GameContainer container, Graphics g) throws SlickException { 
		g.drawString("GameObject: " + GameObject.list.size(), 0, 100); 
		g.drawString("VisualObject: " + VisualObject.list.size(), 0, 120); 
		g.drawString("Github GOGOGOGOGo", 0, 140);
	} 
	
	
	public static void main(String[] args) { 
		try { 
			AppGameContainer app = new AppGameContainer(new PlattformMP()); app.start();
			} 
		catch (SlickException e) { 
			e.printStackTrace(); } 
		} 
	}