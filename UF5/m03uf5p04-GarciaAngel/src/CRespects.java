
public class CRespects extends Component implements IObserver {
	
	public CRespects(GameObject parent) {
		super(parent);
	}

	@Override
	public void update() {
	}

	@Override
	public void notify(String event, GameObject sender) {
		if (event.equals("DEAD"))
			System.out.println("F " + sender.getComponent(CName.class).name);
	}
}
