package ExamenPatterns;

public abstract class Machine {
	String name;
	
	public Machine(String name) {
		super();
		this.name = name;
	}

	public abstract void Action();
}
