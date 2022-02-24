
public class Timeout extends Component {
	double liveTime;
	int liveRemaining = -1;
	
	public Spawner goPool;
	CName name;
	
	public Timeout(GameObject parent, CName name) {
		super(parent);
		liveTime = Math.random() * 5;
		this.name = name;
	}

	@Override
	public void update() {
		liveTime -= GameLoop.getDeltaTime();
		
		if (liveTime <= 0) {
			System.out.println(name.name + ": He muerto");
			GameLoop.GetInstance().getEventListener().NotifyObservers("DEAD", parent);
			//TimeoutFactory.getInstance().deactivate(parent);
			goPool.pool.tryReturnElement(parent);
		}
		
		if (liveRemaining != (int) liveTime) {
			liveRemaining = (int) liveTime;
			System.out.println(name.name + ": Tiempo de vida restante " + (liveRemaining + 1));
		}
	}
	
	public void reset() {
		liveTime = Math.random() * 5;
		liveRemaining = -1;
	}
}
