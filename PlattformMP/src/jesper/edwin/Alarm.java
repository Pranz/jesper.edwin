package jesper.edwin;

import java.util.ArrayList;
import java.util.List;

public class Alarm extends GameObject {
	/*
	 * Alarm, timer.
	 * Currently, if any superclass to the class that makes an alarm
	 * got a alarm with the same number, both alarm functions will be called.
	 * make unique alarm ID's and reserve space.
	 */
	
	static List<Alarm> list = new ArrayList<Alarm>();
	
	int counter = 0;
	int ticks;
	GameObject host;
	
	public Alarm(int ticks, GameObject host){
		super();
		list.add(this);
		this.ticks = ticks;
		this.host = host;
	}
	
	@Override public void update(){
		if(counter >= ticks){
			host.callAlarm(this);
			destroy();
		}
		counter++;
		
		
	}
	
	@Override public void destroy(){
		super.destroy();
		list.remove(this);
	}
	
	public Alarm loop(){
		return new Alarm(ticks, host);
	}

}
