import java.util.ArrayList;

public class PoolOld {
	ArrayList<GameObject> m_gameObjects;
	ArrayList<GameObject> m_gameObjects_using;
	
	public PoolOld() {
		this.m_gameObjects = new ArrayList<GameObject>();
		this.m_gameObjects_using = new ArrayList<GameObject>();
	}
	
	public GameObject getElement() {
		if (!m_gameObjects.isEmpty()) {
			GameObject go = m_gameObjects.remove(0);
			m_gameObjects_using.add(go);
			return go;
		}
		return null;	
	}
	
	public boolean tryReturnElement(GameObject gameObject) {
		if (m_gameObjects_using.remove(gameObject)) {
			m_gameObjects.add(gameObject);
			return true;
		}
		return false;
	}

}
