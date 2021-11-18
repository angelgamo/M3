import java.util.ArrayList;

public class StackStateMachine extends StateMachine {
	class Stack<T> {
		ArrayList<T> list;
		
		public Stack() {
			super();
			this.list = new ArrayList<T>();
		}
		
		public void add(T item) {
			list.add(item);
		}
		
		public void set(T item) {
			list.set(list.size()-1, item);
		}
		
		public T get() {
			if (!list.isEmpty()) {
				return list.get(list.size()-1);
			}
			return null;
		}
		
		public void pop() {
			if (!list.isEmpty()) {
				list.remove(list.get(list.size()-1));
			}
		}
		
		public int size() {
			return list.size();
		}
	}
	
	Stack<State> stackStates;
	
	public StackStateMachine() {
		super();
		this.stackStates = new Stack<State>();
	}
	
	@Override
	public void addState(State state) {
		if (currentState == null) {
			stackStates.add(state);
			currentState = stackStates.get();
			currentState.init();
		}
		states.add(state);
	}
	
	@Override
	public void setState(Class<? extends State> stateClass) {
		for (State state : states) {
			if (state.getClass() == stateClass) {
				currentState.exit();
				stackStates.set(state);
				currentState = stackStates.get();
				currentState.init();
			}
		}
	}
	
	public void pushState(Class<? extends State> stateClass) {
		for (State state : states) {
			if (state.getClass() == stateClass) {
				currentState.exit(); // Maybe
				stackStates.add(currentState);
				currentState = stackStates.get();
				currentState.init();
			}
		}
	}
	
	public void popState() {
		if (stackStates.size() > 1) {
			currentState.exit();
			stackStates.pop();
			currentState = stackStates.get();
			currentState.init();
		}
	}
}
