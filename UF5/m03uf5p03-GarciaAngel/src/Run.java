
public class Run extends State {

	public Run() {
		super("Run");
	}

	@Override
	void init() {
		System.out.println("Init State: " + this.name);
	}

	@Override
	void update() {
		System.out.println("Update State: " + this.name);
	}

	@Override
	void exit() {
		System.out.println("Exit State: " + this.name);
	}
}
