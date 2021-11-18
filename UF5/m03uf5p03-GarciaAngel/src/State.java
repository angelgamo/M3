
public abstract class State {
	String name;
	
	public State(String name) {
		super();
		this.name = name;
	}
	
	abstract void init();
	
	abstract void update();
	
	abstract void exit();
}
