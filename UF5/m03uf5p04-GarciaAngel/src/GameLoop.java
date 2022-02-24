import java.util.ArrayList;

public class GameLoop {
	
	static GameLoop instance;
	
	long now;
	long lastLoopTime = System.nanoTime();
	static double deltaTime;
	final long OPTIMAL_TIME = 1000000000 / 60;
	
	ArrayList<GameObject> m_GameObjects = new ArrayList<GameObject>();
	ArrayList<GameObject> m_GameObjectsToAdd = new ArrayList<GameObject>();
	ArrayList<GameObject> m_GameObjectstoRemove = new ArrayList<GameObject>();
	
	static EventListener eventListener;
	
	ArrayList<GameObject> m_Respected_GameObjects = new ArrayList<GameObject>();
	
	private GameLoop() {
		super();
	}
	
	public static GameLoop GetInstance() {
		if (instance == null) {
			instance = new GameLoop();
			eventListener = EventListener.getInstance();
		}
		return instance;
	}
	
	public void init() {
		//addGameObject(new Timer());
		addGameObject(new Spawner(3));
		
		for (int i = 0; i < 10; i++) {
			GameObject gameObject = new GameObject();
			gameObject.addComponent(new CRespects(gameObject));
			eventListener.RegisterObserver("DEAD", gameObject.getComponent(CRespects.class));
			m_Respected_GameObjects.add(gameObject);
		}
	}
	
	public void input() {
		
	}
	
	public void update() {
		now = System.nanoTime();
		deltaTime = (now - lastLoopTime) / 1000000000f;
		lastLoopTime = now;
		
		if (!m_GameObjects.isEmpty()) 
			for (GameObject gameObject : m_GameObjects) 
				gameObject.update();
		
		m_GameObjects.addAll(m_GameObjectsToAdd);
		m_GameObjectsToAdd.clear();
		m_GameObjects.removeAll(m_GameObjectstoRemove);
		m_GameObjectstoRemove.clear();
	}
	
	public void render() {
	}
	
	public void addGameObject(GameObject gameObject) {
		m_GameObjectsToAdd.add(gameObject);
	}
	
	public void removeGameObject(GameObject gameObject) {
		m_GameObjectstoRemove.add(gameObject);
	}
	
	public static double getDeltaTime() {
		return deltaTime;
	}
	
	public EventListener getEventListener() {
		return eventListener;
	}
}
