package jesper.edwin;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public abstract class GameObject {
	

	static List<GameObject> list = new ArrayList<GameObject>();
	static final int RIGHT = 1;
	static final int LEFT = -1;
	boolean cuedForRemoval = false;
	Alarm superTest;
	
	public GameObject(){
		list.add(this);
	}

	
	public void update(){

	}
	
	public void destroy(){
		list.remove(this);
	}
	
	public void callAlarm(Alarm alarm){
		if(alarm == superTest)System.out.println("YESYESYES");
	}
	
	public double increaseNumberTo(double oldValue, double speed, double target){
		/*
		 * move a to c with a speed of b
		 * @param oldValue The variable you want to move. Often used as var = increaseNumberTo(var, 0.2, 0);
		 * @param speed The speed you want to move a with.
		 * @param target The target you want to move closer to. 
		 * 
		 */
		
		if(Math.abs(oldValue - target) <= speed)return target;
		//if (false) return 0;
		else{
			oldValue -= target;
			return((Math.abs(oldValue)-speed) * sign(oldValue) + target);
		}
	}
	
	public static final int sign(double diff){
    if ( diff > 0 )
        {
        return 1;
        }
    if ( diff < 0 )
        {
        return -1;
        }
    else
        {
        return 0;
        }
    }
	
	public static final int signum(double diff){
		//is used when you want to return 1 although the diff is 0. Yeah, ska skriva om den sen.
	    if ( diff > 0 )
	        {
	        return 1;
	        }
	    if ( diff < 0 )
	        {
	        return -1;
	        }
	    else
	        {
	        return 1;
	        }
	    }


}
