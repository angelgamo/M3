import java.util.ArrayList;
import java.util.HashMap;

public class EventManager {
	HashMap<String,ArrayList<Observer>> list;
	
	public EventManager() {
		list = new HashMap<String,ArrayList<Observer>>();
	}
	
	public void RegisterObserver(String event, Observer observer){
		if (!list.containsKey(event)) {
			ArrayList<Observer> observers = new ArrayList<Observer>();
			list.put(event, observers);
		}
		
		ArrayList<Observer> observers = list.get(event);
		observers.add(observer);
	}
	
	public void UnregisterObserver(String event, Observer observer) {
		ArrayList<Observer> observers = list.get(event);
		
		if (observers != null) {
			observers.remove(observer);
		}
	}
	
	public void NotifyObservers(String event) {
		ArrayList<Observer> observers = list.get(event);
		
		if (observers != null) {
			for (Observer observer : observers) {
				observer.update(event);
			}
		}
	}
}

