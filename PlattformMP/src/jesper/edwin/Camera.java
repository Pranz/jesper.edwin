package jesper.edwin;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class Camera extends GameObject{
	private static double drawX=0;
	private static double drawY=0;
	
	private static double drawX_followMargin=-300;
	private static double drawY_followMargin=-300;
	
	public static boolean drawX_minEnabled=true;
	public static double drawX_min=0;
	public static boolean drawX_maxEnabled=false;
	public static double drawX_max=0;
	public static boolean drawY_minEnabled=false;
	public static double drawY_min=0;
	public static boolean drawY_maxEnabled=true;
	public static double drawY_max=1000;
	
	public static Entity followsObject=null;

	public Camera(){
		super();
	}
	
	public void cameraMoveX(double x){
		if(Math.signum(x)==1){
			if(drawX_maxEnabled)
				drawX=Math.min(drawX+x,drawX_max-PlattformMP.WINDOW_WIDTH);
			else
				drawX+=x;
		}
		else if(Math.signum(x)==-1){
			if(drawX_minEnabled)
				drawX=Math.max(drawX+x,drawX_min);
			else
				drawX+=x;
		}
	}	
		
	public void cameraMoveY(double y){
		if(Math.signum(y)==1){
			if(drawY_maxEnabled)
				drawY=Math.min(drawY+y,drawY_max-PlattformMP.WINDOW_HEIGHT);
			else
				drawY+=y;
		}
		else if(Math.signum(y)==-1){
			if(drawY_minEnabled)
				drawY=Math.max(drawY+y,drawY_min);
			else
				drawY+=y;
		}	
	}
	
	public void cameraSetX(double x){
		if(Math.signum(x)==1){
			if(drawX_maxEnabled)
				drawX=Math.min(x,drawX_max-PlattformMP.WINDOW_WIDTH);
			else
				drawX=x;
		}
		else if(Math.signum(x)==-1){
			if(drawX_minEnabled)
				drawX=Math.max(x,drawX_min);
			else
				drawX=x;
		}	
	}
	
	public void cameraSetY(double y){
		if(Math.signum(y)==1){
			if(drawY_maxEnabled)
				drawY=Math.min(y,drawY_max-PlattformMP.WINDOW_HEIGHT);
			else
				drawY=y;
		}
		else if(Math.signum(y)==-1){
			if(drawY_minEnabled)
				drawY=Math.max(y,drawY_min);
			else
				drawY=y;
		}	
	}
	
	public double getDrawX(){
		return drawX;
	}

	public double getDrawY(){
		return drawY;
	}
	
	protected void handleInput(GameContainer container){
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_A)){
			cameraMoveX(-3);
		}
		
		if(input.isKeyDown(Input.KEY_D)){
			cameraMoveX(3);
		}
		
		if(input.isKeyDown(Input.KEY_W)){
			cameraMoveY(-3);
		}
		
		if(input.isKeyDown(Input.KEY_S)){
			cameraMoveY(3);
		}
		
		if(input.isKeyPressed(Input.KEY_Q)){
			if(followsObject==null)
				followsObject=PlattformMP.player.ent;
			else
				followsObject=null;
		}
	}
	
	@Override public void update(){
		if(followsObject!=null){
			cameraSetX(followsObject.x+drawX_followMargin);
			cameraSetY(drawY=followsObject.y+drawY_followMargin);
		}
		handleInput(PlattformMP.globalContainer);
		super.update();
	}
}