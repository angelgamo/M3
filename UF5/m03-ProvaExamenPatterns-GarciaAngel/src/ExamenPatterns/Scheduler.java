package ExamenPatterns;

import java.util.ArrayList;
import java.util.HashMap;

public class Scheduler {
	ArrayList<Settler> settlers;

	public Scheduler() {
		super();
		settlers = new ArrayList<Settler>();
	}

	public void RegisterSettlers(Settler settler) {
		settlers.add(settler);
	}
	
	public void UnRegisterSettlers(Settler settler) {
		settlers.remove(settler);
	}

	public void NotifySettlers(int roomID) throws Exception{
		for (int i = settlers.size()-1; i >= 0; i--) {
			settlers.get(i).Work(roomID);
		}
	}
}
