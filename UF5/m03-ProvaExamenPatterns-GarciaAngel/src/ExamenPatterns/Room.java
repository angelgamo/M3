package ExamenPatterns;

import java.util.HashSet;
import java.util.Set;

public class Room {
	static int autonumeric = 0;
	int id;
	Set<Machine> machines;
	
	public Room() {
		super();
		machines = new HashSet<Machine>();
		this.id = autonumeric;
		autonumeric++;
	}
	
	public void AddMachine(Machine machine) {
		machines.add(machine);
	}
	
	public void RemoveMachine(Machine machine) {
		machines.remove(machine);
	}
	
	public void Work() {
		System.out.println("Room " + id + " executing tasks:");
		for (Machine machine : machines) {
			machine.Action();
		}
	}

	public int GetId() {
		return id;
	}

	public Set<Machine> GetMachines() {
		return machines;
	}
}
