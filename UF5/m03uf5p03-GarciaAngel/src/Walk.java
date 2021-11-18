
public class Walk extends State {

	public Walk() {
		super("Walk");
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
