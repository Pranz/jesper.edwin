package jesper.edwin; 


import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.newdawn.slick.*; 


public class PlattformMP extends BasicGame { 
	
	VisualObject player;
	
	static boolean PAUSE = false;
	
	private final int FPS = 100;
	private final int WINDOW_LENGTH = 640;
	private final int WINDOW_HEIGHT = 480;
	private final String WORK_DIR =System.getProperty("user.dir");
	private final String IMAGE_DIR = WORK_DIR + "/resources/image/";
	
	Console console = new Console();
	
	Keyboard keyboard = new Keyboard();

	
	public PlattformMP() { 
		super("PlattformMP"); 
		} 
	
	@Override public void init(GameContainer container) throws SlickException {
		
		player = new VisualObject(new Image(IMAGE_DIR + "player.png"), 140, 70);
		container.setTargetFrameRate(FPS);
	} 
	
	@Override public void update(GameContainer container, int delta) throws SlickException {
		if(!PlattformMP.PAUSE){
			handleInput(container);
			
			for(int i = 0; i < GameObject.list.size(); i++){
				GameObject.list.get(i).update();
			}
			
		}
		else pauseUpdate();
	} 
	
	public void pauseUpdate(){
		
	}
	
	
	@Override public void render(GameContainer container, Graphics g) throws SlickException { 
		
		for(VisualObject o : VisualObject.list){
			g.drawImage(o.image, (int)(o.x), (int)(o.y));
		}
		
		g.drawString("GameObject: " + GameObject.list.size(), 0, 100); 
		g.drawString("VisualObject: " + VisualObject.list.size(), 0, 120); 
		//tog bort all onödig skit för tillfället
		
		if(Console.isOn) drawConsole(g);
	} 
	
	
	public static void main(String[] args) { 
		try { 
			AppGameContainer app = new AppGameContainer(new PlattformMP()); 
			app.start();
			} 
		catch (SlickException e) { 
			e.printStackTrace(); } 
		} 
	
	/*
	protected void handleInput(GameContainer container){
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			player.move(-2, 0);
		}
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			player.move(2, 0);
		}
		
		if(input.isKeyDown(Input.KEY_DOWN)){
			player.move(0, 2);
		}
		
		if(input.isKeyDown(Input.KEY_UP)){
			player.move(0, -2);
		}
	}
	*/
	
	private void handleInput(GameContainer gc) throws SlickException {
		gc.getInput().addKeyListener(keyboard);
	}
	
	private void drawConsole(Graphics g){
		g.setColor(Color.darkGray);
		g.fillRect(0,480-20,640,480);
		String[] consoleOut = Console.output.split(Character.toString((char)10));
		for(int i=0;i<consoleOut.length;i++)
			g.drawString(consoleOut[i], 6, WINDOW_HEIGHT - 20- ((consoleOut.length-i) * 20));
		g.setColor(Color.white);
		g.drawString("> " + Console.input, 6, 480-20);
		g.drawLine(26+Console.input.length()*9, WINDOW_HEIGHT-20+2, 26+Console.input.length()*9, WINDOW_HEIGHT-2);
	}
	
}
