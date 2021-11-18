import java.util.HashSet;
import java.util.Set;

public class StateMachine {
	Set<State> states;
	State currentState;
	
	public StateMachine() {
		super();
		this.states = new HashSet<State>();
	}
	
	public void addState(State state) {
		if (currentState == null) {
			currentState = state;
			currentState.init();
		}
		states.add(state);
	}
	
	public void setState(Class<? extends State> stateClass) {
		for (State state : states) {
			if (state.getClass() == stateClass) {
				currentState.exit();
				currentState = state;
				currentState.init();
			}
		}
	}
	
	public void update() {
		if (currentState != null) {
			currentState.update();
		}
	}
}
