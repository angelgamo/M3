import java.util.ArrayList;
import java.util.HashMap;

public class EventManager 
{
	static EventManager instance;
	HashMap<String,ArrayList<Observer>> list;
	
	private EventManager() 
	{
		super();
		list = new HashMap<String,ArrayList<Observer>>();
	}
	
	public static EventManager getInstance() 
	{
		if (instance == null) instance = new EventManager();
		return instance;
	}
	
	public void RegisterObserver(String event, Observer observer)
	{
		if (!list.containsKey(event)) 
		{
			ArrayList<Observer> observers = new ArrayList<Observer>();
			list.put(event, observers);
		}
		
		ArrayList<Observer> observers = list.get(event);
		observers.add(observer);
	}
	
	public void UnregisterObserver(String event, Observer observer) 
	{
		ArrayList<Observer> observers = list.get(event);
		
		if (observers != null) {
			observers.remove(observer);
		}
	}
	
	public void NotifyObservers(String event, Object object) 
	{
		ArrayList<Observer> observers = list.get(event);
		
		if (observers != null) 
		{
			for (int i = observers.size()-1; i >= 0; i--) 
			{
				observers.get(i).event(event, object);
			}
		}
	}
	
}
