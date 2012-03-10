package jesper.edwin; 

import org.newdawn.slick.*; 



public class PlattformMP extends BasicGame { 
	
	VisualObject player;
	
	private final String IMAGE_DIR = System.getProperty("user.dir") + "/resources/image/";

	
	public PlattformMP() { 
		super("PlattformMP"); 
		} 
	
	@Override public void init(GameContainer container) throws SlickException {
		
		VisualObject player = new VisualObject(new Image(IMAGE_DIR + "player.png"), 140, 70);
		container.setTargetFrameRate(100);
	} 
	
	@Override public void update(GameContainer container, int delta) throws SlickException {
		handleInput(container);
	} 
	
	@Override public void render(GameContainer container, Graphics g) throws SlickException { 
		
		g.drawString("GameObject: " + GameObject.list.size(), 0, 100); 
		g.drawString("VisualObject: " + VisualObject.list.size(), 0, 120); 
		//tog bort all onödig skit för tillfället
		
		//kod som ritar ut alla VisualObject
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
	
	protected void handleInput(GameContainer container){
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			player.x -= 2;
		}
		
		
	}
	
	}