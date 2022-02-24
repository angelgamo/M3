
public abstract class Component {
	GameObject parent;
	
	public Component(GameObject parent) {
		super();
		this.parent = parent;
	}
	
	abstract public void update();
}
