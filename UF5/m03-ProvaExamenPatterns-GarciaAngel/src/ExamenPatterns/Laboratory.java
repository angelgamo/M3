package ExamenPatterns;

public class Laboratory extends Machine {
	public Laboratory(String name) {
		super(name);
	}

	@Override
	public void Action() {
		System.out.println(name + " - doing chemistry");
	}
}
