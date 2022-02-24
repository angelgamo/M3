import java.util.ArrayList;

public class Spawner extends GameObject {
	double time = 0;
	double spawnTime;
	
	TimeoutFactory timeoutFactory = TimeoutFactory.getInstance();
	Pool<GameObject> pool;
	
	public Spawner(float spawnTime) {
		super();
		this.spawnTime = spawnTime;
		
		
		ArrayList<GameObject> list  = new ArrayList<GameObject>();
		for (int i = 0; i < 10; i++)
			list.add(timeoutFactory.create());
		pool = new Pool<GameObject>(list, timeoutFactory);
	}
	
	@Override
	public void update() {
		time += GameLoop.getDeltaTime();
		if (time >= spawnTime) {
			time -= spawnTime;
			pool.Shuffle();
			GameObject timeout = pool.getElement();
			timeout.getComponent(Timeout.class).goPool = this;
			System.out.println(timeout.getComponent(CName.class).name + ": Spawn ");
		}
	}

	@Override
	public void render() {
	}
}
