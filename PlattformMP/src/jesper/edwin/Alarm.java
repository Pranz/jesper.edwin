package jesper.edwin;

import java.util.ArrayList;
import java.util.List;

public class Alarm extends GameObject {
	
	static List<Alarm> list = new ArrayList<Alarm>();
	static List<Alarm> removeList = new ArrayList<Alarm>();
	
	int counter = 0;
	int ticks;
	int number;
	GameObject host;
	
	public Alarm(int number, int ticks, GameObject host){
		super();
		list.add(this);
		this.ticks = ticks;
		this.number = number;
		this.host = host;
	}
	
	@Override public void update(){
		if(counter >= ticks){
			host.callAlarm(number);
			//loop();
			destroy();
		}
		counter++;
		
	}
	
	@Override public void destroy(){
		removeList.add(this);
		super.destroy();
	}
	
	protected void loop(){
		new Alarm(number, ticks, host);
	}

}
