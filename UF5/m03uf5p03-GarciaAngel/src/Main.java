
public class Main {
	public static void main(String[] args) {
		// Magicka test
			System.out.println("Magicka Test");
			Spell bolaDeFuego = new Spell("bola de fuego");
			bolaDeFuego.addElement(new Fire());
			bolaDeFuego.addElement(new Wind());
		
			bolaDeFuego.cast();
		
		// GameObject test
			System.out.println("\nGameObject test");
			A a = new A();
			B b = new B();
			
			GameObject go = new GameObject();
			
			go.addComponent(a);
			
			System.out.println("GameObject has component A: " + go.hasComponent(A.class));
			System.out.println("GameObject has component B: " + go.hasComponent(B.class));
			
			System.out.println("GameObject get component A: " + go.getComponent(A.class));
			System.out.println("GameObject get component B: " + go.getComponent(B.class));
			
			System.out.println("Remove components A & B");
			go.removeComponent(a);
			go.removeComponent(b);
			
			System.out.println("GameObject has component A: " + go.hasComponent(A.class));
			System.out.println("GameObject has component B: " + go.hasComponent(B.class));
			
		// State Machine test
			System.out.println("\nState Machine test");
			Idle idle = new Idle();
			Run run = new Run();
			Walk walk = new Walk();
			
			StateMachine stateMachine = new StateMachine();
			
			stateMachine.addState(idle);
			stateMachine.addState(walk);
			stateMachine.addState(run);
			
			System.out.println("-> Update");
			stateMachine.update();
			System.out.println("-> Set Run");
			stateMachine.setState(Run.class);
			System.out.println("-> Update");
			stateMachine.update();
			System.out.println("-> Set Walk");
			stateMachine.setState(Walk.class);
			System.out.println("-> Update");
			stateMachine.update();
			
		// Stack State Machine test
			System.out.println("\nStack State Machine test");
			
			StackStateMachine stackStateMachine = new StackStateMachine();
			
			stackStateMachine.addState(idle);
			stackStateMachine.addState(walk);
			stackStateMachine.addState(run);
			
			System.out.println("-> Update");
			stackStateMachine.update();
			System.out.println("-> Push Run");
			stackStateMachine.pushState(Run.class);
			System.out.println("-> Update");
			stackStateMachine.update();
			System.out.println("-> Pop");
			stackStateMachine.popState();
			System.out.println("-> Update");
			stackStateMachine.update();
			System.out.println("-> Pop");
			stackStateMachine.popState();
			System.out.println("-> Update");
			stackStateMachine.update();
			System.out.println("-> Set Walk");
			stackStateMachine.setState(Walk.class);
			System.out.println("-> Update");
			stackStateMachine.update();
	}
}
