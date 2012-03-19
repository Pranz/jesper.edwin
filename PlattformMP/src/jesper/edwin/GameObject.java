package jesper.edwin;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public abstract class GameObject {
	
	public int alarmNumber = 0;
	static List<GameObject> list = new ArrayList<GameObject>();
	static final int RIGHT = 1;
	static final int LEFT = -1;
	boolean cuedForRemoval = false;
	
	public GameObject(){
		list.add(this);
	}

	
	public void update(){

	}
	
	public void destroy(){
		list.remove(this);
	}
	
	public void callAlarm(int number, Alarm alarm){
		if(number == 0){
			System.out.println("Testing");
			//alarm.loop();
		}
	}
	
	public double increaseNumberTo(double oldValue, double speed, double target){
		/*
		 * move a to c with a speed of b
		 * @param oldValue The variable you want to move. Often used as var = increaseNumberTo(var, 0.2, 0);
		 * @param speed The speed you want to move a with.
		 * @param target The target you want to move closer to. 
		 * 
		 */
		
		if(oldValue != 0 && Math.abs(oldValue - target*sign(oldValue)) <= speed)return target*sign(oldValue);
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

}
