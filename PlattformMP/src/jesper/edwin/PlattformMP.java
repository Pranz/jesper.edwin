package jesper.edwin; 

import org.newdawn.slick.*; 
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.font.effects.OutlineEffect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.lang.Math;


public class PlattformMP extends BasicGame { 
	
	static Player player;
	static boolean PAUSE = false;
	
	public final int FPS = 60;
	public static final int WINDOW_WIDTH = 640;
	public static final int WINDOW_HEIGHT = 480;
	public static final String WORK_DIR =System.getProperty("user.dir");
	private final String IMAGE_DIR = WORK_DIR + "/resources/image/";
	private final String FONT_DIR = WORK_DIR + "/resources/fonts/";
	Image sprWhiteBlock, sprPlayer, sprEntityTest, sprTriangle, sprTriangle2, sprTriangle3;
	public static UnicodeFont fontDefault;
	boolean initiated = false;
	
	static Console console = new Console();
	static Camera camera = new Camera();
	
	Keyboard keyboard = new Keyboard();
	Mouse mouse = new Mouse();
	static GameContainer globalContainer;

	public PlattformMP() { 
		super("PlattformMP"); 
		} 
	
	@Override public void init(GameContainer container) throws SlickException {		
		sprWhiteBlock  = new Image(IMAGE_DIR + "whiteblock.png");
		sprPlayer = new Image(IMAGE_DIR + "player.png");
		sprEntityTest = new Image(IMAGE_DIR + "entity_test.png");
		sprTriangle = new Image(IMAGE_DIR + "whitetriangle.png");
		sprTriangle2 = new Image(IMAGE_DIR + "whitetriangle2.png");
		sprTriangle3 = new Image(IMAGE_DIR + "whitetriangle3.png");
		
		fontDefault = new UnicodeFont(FONT_DIR + "AndaleMono.ttf", 16, false, false);
		fontDefault.addAsciiGlyphs();
		fontDefault.addGlyphs(400, 600);
		OutlineEffect fontOutline=new OutlineEffect();
		fontOutline.setWidth(2);
		fontDefault.getEffects().add(fontOutline);
		fontDefault.getEffects().add(new ColorEffect());
		fontDefault.loadGlyphs();
		
		player = new Player(new Entity(200, 70, sprPlayer), 0);
		new Solid(180, 320, sprWhiteBlock);
		new BasicCreature(260, 200, sprEntityTest);
		container.setTargetFrameRate(FPS);
		globalContainer = container;
		container.setShowFPS(false);
		
		new SlopeTerrain(220, WINDOW_HEIGHT - 64, sprTriangle2);
		
		for(int i = 0; i < WINDOW_WIDTH / 32; i++){
			new Solid(i*32, WINDOW_HEIGHT-32, sprWhiteBlock);
		}
		
		for(int i = 0; i < 10; i++){
			new SlopeTerrain(320 + 32*i, WINDOW_HEIGHT - 32*i, sprTriangle);
		}
		
		for(int i = 0; i < 10; i++){
			new SlopeTerrain(580 + 16*i, WINDOW_HEIGHT - 32*i, sprTriangle3);
		}
		
		initiated = true;
	} 
	
	@Override public void update(GameContainer container, int delta) throws SlickException {
		globalContainer = container;
		
		
		if(!PlattformMP.PAUSE){
			handleInput(container);
			handleMouseInput(container);
			List<GameObject> l = GameObject.list;
			
			for(int i = 0; i < l.size(); i++){
				l.get(i).update();
			}
			
		}
		else pauseUpdate();
	} 
	
	public void pauseUpdate(){
		
	}
	
	
	@Override public void render(GameContainer container, Graphics g) throws SlickException { 
		//TODO: Render prioritet som Game Makers depth
	    Collections.sort(Renderable.list, new Comparator<Object>(){

	        public int compare(Object o1, Object o2) {
	        	Renderable v1 = (Renderable) o1;
	        	Renderable v2 = (Renderable) o2;
	           return (v1.depth - v2.depth);
	        }});

		
		for(Renderable o : Renderable.list){
			o.render(g);
		}

		
		List<String> l = new ArrayList<String>();
		l.add("FPS: " + container.getFPS());
		l.add("GameObject: " + GameObject.list.size());
		l.add("VisualObject: " + VisualObject.list.size());
		l.add("hspeed: " + (double)Math.round(player.ent.hspeed*10)/10);
		l.add("vspeed: " + (double)Math.round(player.ent.vspeed*10)/10);
		l.add("x: " + player.ent.x);
		l.add("y: " + player.ent.y);
		l.add("Console Timer: "+console.consoleTimer.ticks+" / "+console.consoleTimer.maxTicks);
		l.add("Angle: " + GameObject.directionToPoint(player.ent.previousX, player.ent.previousY, player.ent.x, player.ent.y));
		l.add("Camera: " + camera.getDrawX() + ","+camera.getDrawY());
		
		drawList(g,l);
		
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
	
	private void handleMouseInput(GameContainer gc) throws SlickException {
		gc.getInput().addMouseListener(mouse);
	}
	
	public void drawList(Graphics g, List<String> list){
		for(int i = 0; i < list.size(); i++){
			g.drawString(list.get(i), 0, i*18);
		}
	}
	
}
