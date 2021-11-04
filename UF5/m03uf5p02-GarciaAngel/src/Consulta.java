import java.util.ArrayList;

public class Consulta {
	ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void Register(Observer observer) {
		observers.add(observer);
	}
	
	public void Unregister(Observer observer) {
		observers.remove(observer);
	}
	
	public void NotifyObserver(String name) {		
		for (int i = observers.size() - 1; i >= 0; i--) {
			observers.get(i).update(name);
		}
	}
}
