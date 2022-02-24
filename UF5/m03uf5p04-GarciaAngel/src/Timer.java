
public class Timer extends Component {
	double time = 0;
	int lastSecond = 0;
	
	public Timer(GameObject parent) {
		super(parent);
	}
	
	@Override
	public void update() {
		time += GameLoop.getDeltaTime();
		if ((int)time > lastSecond) {
			lastSecond = (int)time;
			System.out.println(time);
		}
	}
}
