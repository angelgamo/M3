package ExamenPatterns;

import java.util.HashSet;
import java.util.Set;

public class Colony {
	Set<Room> rooms;

	public Colony() {
		super();
		rooms = new HashSet<Room>();
	}
	
	public void AddRoom(Room room) {
		rooms.add(room);
	}
	
	public void RemoveRoom(Room room) {
		rooms.remove(room);
	}
	
	public Room GetRoom(int roomID) throws Exception {
		for (Room room : rooms) {
			if (room.GetId() == roomID) {
				return room;
			}
		}
		throw new Exception("room with id: " + roomID + " does not exists");
	}
}
