package ExamenPatterns;

public class Dispenser extends Machine {
	public Dispenser(String name) {
		super(name);
	}

	@Override
	public void Action() {
		System.out.println(name + " - dispensing");
	}
}
