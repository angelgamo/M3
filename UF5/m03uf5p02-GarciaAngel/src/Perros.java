import java.util.ArrayList;

public class Perros implements Observer {
	ArrayList<String> events = new ArrayList<String>();
	
	public Perros(String event) {
		this.events.add(event);
	}
	
	public void AddEvent(String event) {
		if (!events.contains(event)) events.add(event);
	}

	@Override
	public void update(String event) {
		for (String eventSuscrebed: events) {
			if (eventSuscrebed.equals(event)) {
				System.out.println(this + " raised");
				// unregister
			}
		}
	}

	@Override
	public String toString() {
		return "Perros [events=" + events + "]";
	}
}
