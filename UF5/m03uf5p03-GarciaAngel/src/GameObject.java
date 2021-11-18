import java.util.ArrayList;

public class GameObject {
	ArrayList<Component> components;
	
	public GameObject() {
		super();
		this.components = new ArrayList<Component>();
	}
	
	public void addComponent(Component component) {
		components.add(component);
	}
	
	public void removeComponent(Component component){
		components.remove(component);
	}
	
	public boolean hasComponent(Class<? extends Component> className){
		for (Component component : components) {
			if (className.isInstance(component)){
				return true;
			}
		}
		return false;
	}
	
	public <T extends Component> T getComponent(Class<T> className){
		for (Component component : components) {
			if (className.isInstance(component)){
				return className.cast(component);
			}
		}
		return null;
	}
	
	public void update(){
		
	}
}
