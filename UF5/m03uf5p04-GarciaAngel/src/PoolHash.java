import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PoolHash<T> {
	HashMap<T, Boolean> elements = new HashMap<T, Boolean>();
	IPoolableFactory<T> factory;
	
	public PoolHash(ArrayList<T> elements, IPoolableFactory<T> factory) {
		for (T element : elements) {
			this.elements.put(element, true);
		}
		this.factory = factory;
	}
	
	public T getElement() {
		for (Map.Entry<T, Boolean> set : elements.entrySet()) {
			if (set.getValue()) {
				elements.put(set.getKey(), false);
				factory.activate(set.getKey());
				return set.getKey();
			}
		}
		return null;
	}
	
	public boolean tryReturnElement(T element) {
		for (Map.Entry<T, Boolean> set : elements.entrySet()) {
			if (set.getKey().equals(element)) {
				elements.put(set.getKey(), true);
				factory.deactivate(element);
				return true;
			}
		}
		return false;
	}
}
