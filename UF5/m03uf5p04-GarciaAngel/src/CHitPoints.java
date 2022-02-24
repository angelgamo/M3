
public class CHitPoints extends Component {
	int healthPoints;
	
	public CHitPoints(GameObject parent, int healthPoints) {
		super(parent);
		this.healthPoints = healthPoints;
	}

	@Override
	public void update() {
	}

	public void addHealthPoints(int quantity) {
		healthPoints += quantity;
	}
	
	public void removeHealthPoints(int quantity) {
		healthPoints -= quantity;
	}
	
	public int getHealthPoints() {
		return healthPoints;
	}
}
