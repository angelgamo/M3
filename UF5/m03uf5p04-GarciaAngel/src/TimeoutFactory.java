
public class TimeoutFactory implements IPoolableFactory<GameObject> {

	static TimeoutFactory instance;
	
	private TimeoutFactory() {
		super();
	}
	
	public static TimeoutFactory getInstance() {
		if (instance == null)
			instance = new TimeoutFactory();
		return instance;
	}
	
	@Override
	public GameObject create() {
		GameObject gameObject = new GameObject();
		gameObject.addComponent(new CName(gameObject));
		gameObject.addComponent(new Timeout(gameObject, gameObject.getComponent(CName.class)));
		return gameObject;
	}

	@Override
	public void activate(GameObject element) {
		element.getComponent(Timeout.class).reset();
		GameLoop.GetInstance().addGameObject(element);
	}

	@Override
	public void deactivate(GameObject element) {
		GameLoop.GetInstance().removeGameObject(element);
	}

	@Override
	public void delete(GameObject element) {
	}

}
