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
	
	int ticks = 0;
	int maxTicks;
	GameObject host;
	
	public Alarm(int maxTicks, GameObject host){
		super();
		list.add(this);
		this.maxTicks = maxTicks;
		this.host = host;
	}
	
	@Override public void update(){
		if(ticks >= maxTicks){
			host.callAlarm(this);
			destroy();
		}
		ticks++;
		
		
	}
	
	@Override public void destroy(){
		super.destroy();
		list.remove(this);
	}
	
	public Alarm loop(){
		return new Alarm(maxTicks, host);
	}

}
