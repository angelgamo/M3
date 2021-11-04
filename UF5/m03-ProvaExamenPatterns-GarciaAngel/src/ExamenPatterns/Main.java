package ExamenPatterns;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		Colony colony = new Colony();							// Create Colony
		
		Room Medbay = new Room();								// Create 3 Rooms
		Room Engineering = new Room();
		Room Maintenance = new Room();
		
		Dispenser Dispenser = new Dispenser("Dispenser");		// Create 5 Machine
		Autotreat Autotreat = new Autotreat("Autotreat");
		Laboratory Laboratory = new Laboratory("Laboratory");
		Welding Welding = new Welding("Welding");
		Broom Broom = new Broom("Broom");
		
		Medbay.AddMachine(Dispenser);							// Add Machine to each Room
		Medbay.AddMachine(Autotreat);
		Medbay.AddMachine(Laboratory);
		Engineering.AddMachine(Dispenser);
		Engineering.AddMachine(Laboratory);
		Engineering.AddMachine(Welding);
		Maintenance.AddMachine(Dispenser);
		Maintenance.AddMachine(Welding);
		Maintenance.AddMachine(Broom);
		
		colony.AddRoom(Medbay);									// Add Rooms to Colony
		colony.AddRoom(Engineering);
		colony.AddRoom(Maintenance);
		
		Settler settler1 = new Settler("settler1", 0, colony);	// Create 9 settlers
		Settler settler2 = new Settler("settler2", 1, colony);
		Settler settler3 = new Settler("settler3", 2, colony);
		Settler settler4 = new Settler("settler4", 3, colony);
		Settler settler5 = new Settler("settler5", 4, colony);
		Settler settler6 = new Settler("settler6", 5, colony);
		Settler settler7 = new Settler("settler7", 6, colony);
		Settler settler8 = new Settler("settler8", 7, colony);
		Settler settler9 = new Settler("settler9", 8, colony);
		
		ArrayList<Settler> settlers = new ArrayList<Settler>(Arrays.asList(settler1, settler2, settler3, settler4, settler5, settler6, settler7, settler8, settler9)); // List of settlers
		
		// Day 1
		System.out.println("Day 1:");
		Scheduler scheduleDay = new Scheduler();				// Create Schedule
		
		for (Settler settler : settlers) {						// Add settlers
			scheduleDay.RegisterSettlers(settler);
		}
		
		settler1.SetId(Medbay.GetId());							// Set Room each settler
		settler2.SetId(Medbay.GetId());
		settler3.SetId(Medbay.GetId());
		settler4.SetId(Engineering.GetId());
		settler5.SetId(Engineering.GetId());
		settler6.SetId(Engineering.GetId());
		settler7.SetId(Maintenance.GetId());
		settler8.SetId(Maintenance.GetId());
		settler9.SetId(Maintenance.GetId());
		
		scheduleDay.NotifySettlers(Engineering.GetId());		// NotifyAll
		
		/*for (Settler settler : settlers) {						// End day UnRegisterAll
			scheduleDay.UnRegisterSettlers(settler);
		}*/
		
		// Day 2
		System.out.println("\n\nDay 2:");
		
		/*for (Settler settler : settlers) {
			scheduleDay.RegisterSettlers(settler);
		}*/
		
		settler7.SetId(Medbay.GetId());
		settler8.SetId(Medbay.GetId());
		settler9.SetId(Medbay.GetId());
		settler4.SetId(Engineering.GetId());
		settler5.SetId(Engineering.GetId());
		settler6.SetId(Engineering.GetId());
		settler1.SetId(Maintenance.GetId());
		settler2.SetId(Maintenance.GetId());
		settler3.SetId(Maintenance.GetId());
		
		scheduleDay.NotifySettlers(Maintenance.GetId());
		
		for (Settler settler : settlers) {						// End day UnRegisterAll
			scheduleDay.UnRegisterSettlers(settler);
		}
	}
}
