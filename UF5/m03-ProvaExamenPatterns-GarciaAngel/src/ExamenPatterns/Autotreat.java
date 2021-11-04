package ExamenPatterns;

public class Autotreat extends Machine {
	public Autotreat(String name) {
		super(name);
	}

	@Override
	public void Action() {
		System.out.println(name + " - treating");
	}
}
