package ExamenPatterns;

public class Settler implements Observer {
	String name;
	int id;
	Colony colony;
	
	public Settler(String name, int id, Colony colony) {
		super();
		this.name = name;
		this.id = id;
		this.colony = colony;
	}
	
	public void SetId(int roomID) {
		this.id = roomID;
	}

	@Override
	public void Work(int roomID) throws Exception {
		if (id == roomID) {
			System.out.println(name + " is working");
			colony.GetRoom(roomID).Work();
		}else {
			System.out.println(name + " is chilling");
		}
	}
	
	public String getName() {
		return name;
	}
}
