package ExamenPatterns;

public class Welding extends Machine {
	public Welding(String name) {
		super(name);
	}

	@Override
	public void Action() {
		System.out.println(name + " - assembling stuffies");
	}
}
