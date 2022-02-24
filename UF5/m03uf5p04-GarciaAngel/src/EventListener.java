import java.util.ArrayList;
import java.util.HashMap;

public class EventListener {
	static EventListener instance;
	HashMap<String, ArrayList<IObserver>> list;

	EventListener() {
		super();
		list = new HashMap<String, ArrayList<IObserver>>();
	}

	public static EventListener getInstance() {
		if (instance == null)
			instance = new EventListener();
		return instance;
	}

	public void RegisterObserver(String event, IObserver observer) {
		if (!list.containsKey(event)) {
			ArrayList<IObserver> observers = new ArrayList<IObserver>();
			list.put(event, observers);
		}

		ArrayList<IObserver> observers = list.get(event);
		observers.add(observer);
	}

	public void UnregisterObserver(String event, IObserver observer) {
		ArrayList<IObserver> observers = list.get(event);

		if (observers != null) {
			observers.remove(observer);
		}
	}

	public void NotifyObservers(String event, GameObject sender) {
		ArrayList<IObserver> observers = list.get(event);

		if (observers != null) {
			for (int i = observers.size() - 1; i >= 0; i--) {
				observers.get(i).notify(event, sender);
			}
		}
	}
}
