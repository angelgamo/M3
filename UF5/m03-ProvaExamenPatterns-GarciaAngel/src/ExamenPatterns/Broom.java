package ExamenPatterns;

public class Broom extends Machine {
	public Broom(String name) {
		super(name);
	}

	@Override
	public void Action() {
		System.out.println(name + " - keeping it clean");
	}
}
