package jesper.edwin; 


import org.newdawn.slick.*; 

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;


public class PlattformMP extends BasicGame { 
	
	Player player;
	static boolean PAUSE = false;
	
	private final int FPS = 60;
	private static final int WINDOW_WIDTH = 640;
	private static final int WINDOW_HEIGHT = 480;
	private final String WORK_DIR =System.getProperty("user.dir");
	private final String IMAGE_DIR = WORK_DIR + "/resources/image/";
	
	static Console console = new Console();
	
	Keyboard keyboard = new Keyboard();
	static GameContainer globalContainer;

	
	public PlattformMP() { 
		super("PlattformMP"); 
		} 
	
	@Override public void init(GameContainer container) throws SlickException {
		
		player = new Player(new Entity(200, 70, new Image(IMAGE_DIR + "player.png")), 0);
		new Solid(130, 70, new Image(IMAGE_DIR + "whiteblock.png"));
		new Solid(500, 80, new Image(IMAGE_DIR + "whiteblock.png"));
		container.setTargetFrameRate(FPS);
		globalContainer = container;
		container.setShowFPS(false);
		
	} 
	
	@Override public void update(GameContainer container, int delta) throws SlickException {
		globalContainer = container;
		
		
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
		
		List<String> l = new ArrayList<String>();
		l.add("FPS: " + container.getFPS());
		l.add("GameObject: " + GameObject.list.size());
		l.add("VisualObject: " + VisualObject.list.size());
		l.add("hspeed: " + (double)Math.round(player.ent.hspeed*10)/10);
		l.add("vspeed: " + (double)Math.round(player.ent.vspeed*10)/10);
		l.add("x: " + Math.round(player.ent.x));
		l.add("y: " + Math.round(player.ent.y));
		
		drawList(g,l);
		
		if(console.isOn) drawconsole(g);
	} 
	
	
	public static void main(String[] args) { 
		try { 
			AppGameContainer app = new AppGameContainer(new PlattformMP()); 
			app.setDisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, false);
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
	
	private void drawconsole(Graphics g){
		g.setColor(Color.darkGray);
		g.fillRect(0,WINDOW_HEIGHT-20,WINDOW_WIDTH,WINDOW_HEIGHT);
		String[] consoleOut = console.output.split(Character.toString((char)10));
		for(int i = 0; i < consoleOut.length; i++)
			g.drawString(consoleOut[i], 6, WINDOW_HEIGHT - 20- ((consoleOut.length-i) * 20));
		g.setColor(Color.white);
		g.drawString("> " + console.input, 6, WINDOW_HEIGHT-20);
		g.drawLine(26+console.input.length()*9, WINDOW_HEIGHT-20+2, 26+console.input.length()*9, WINDOW_HEIGHT-2);
	}
	
	public void drawList(Graphics g, List<String> list){
		for(int i = 0; i < list.size(); i++){
			g.drawString(list.get(i), 0, i*18);
		}
	}
	
}
