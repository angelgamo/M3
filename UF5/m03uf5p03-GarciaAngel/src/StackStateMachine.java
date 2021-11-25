import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StackStateMachine {
	Set<State> states;
	Stack<State> stackStates;
	
	public StackStateMachine() {
		super();
		this.states = new HashSet<State>();
		this.stackStates = new Stack<State>();
	}
	
	public void addState(State state) {
		if (stackStates.isEmpty()) {
			stackStates.add(state);
			stackStates.lastElement().init();
		}
		states.add(state);
	}
	
	public void setState(Class<? extends State> stateClass) {
		for (State state : states) {
			if (state.getClass() == stateClass) {
				stackStates.pop().exit();
				stackStates.push(state).init();
			}
		}
	}
	
	public void pushState(Class<? extends State> stateClass) {
		for (State state : states) {
			if (state.getClass() == stateClass) {
				stackStates.lastElement().exit();
				stackStates.push(state).init();
			}
		}
	}
	
	public void popState() {
		if (stackStates.size() > 1) {
			stackStates.pop().exit();
			stackStates.lastElement().init();
		}
	}
	
	public void update() {
		stackStates.get(stackStates.size()-1).update();
	}
}
