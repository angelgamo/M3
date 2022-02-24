import java.util.ArrayList;
import java.util.Collections;

public class Pool<T> {
	ArrayList<T> elements = new ArrayList<T>();
	ArrayList<Boolean> used = new ArrayList<Boolean>();
	IPoolableFactory<T> factory;
	
	public Pool(ArrayList<T> elements, IPoolableFactory<T> factory) {
		for (T element : elements) {
			this.elements.add(element);
			this.used.add(false);
		}
		this.factory = factory;
	}
	
	public T getElement() {
		for (int i = 0; i < elements.size(); i++) {
			if (!used.get(i)) {
				used.set(i, true);
				factory.activate(elements.get(i));
				return elements.get(i);
			}
		}
		return null;
	}
	
	public boolean tryReturnElement(T element) {
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).equals(element)) {
				used.set(i, false);
				factory.deactivate(element);
				return true;
			}
		}
		return false;
	}
	
	public void Shuffle() {
		Collections.shuffle(elements);
	}
}
