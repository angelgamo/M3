import java.util.ArrayList;
import java.util.Collections;

public class test2 {
	public static void main(String[] args) {
		ArrayList<MyClass> lista = new ArrayList<MyClass>();
		
		// Create 4 MyClass
		MyClass a1 = new MyClass("bbb", 20, "perro");
		MyClass a2 = new MyClass("aaa", 20, "perro");
		MyClass a3 = new MyClass("bbb", 19, "perro");
		MyClass a4 = new MyClass("bbb", 20, "gato");
		
		// Add 5 MyClass
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		lista.add(a4);
		lista.add(a4);
		
		// Show list disordered
		System.out.println("list vanilla");
		for (MyClass myClass : lista) {
			System.out.println(myClass);
		}
		
		// Sort list
		Collections.sort(lista);
		
		// Show list sorted
		System.out.println("\nlist sorted	[nombre > edad > nombreMacota]");
		for (MyClass myClass : lista) {
			System.out.println(myClass);
		}
		
		System.out.println("\nQueue Iterator");
		// Create Queue list
		MyQueue<Integer> queue = new MyQueue<Integer>();
		// Add 10 int to Queue
		for (int i = 0; i < 10; i++) {
			queue.push(i);
		}
		// Show iterated Queue
		for (Integer integer : queue) {
			System.out.print(integer);
		}
		
		System.out.println("\n\nStack Iterator");
		// Create Stack list
		MyStack<Integer> stack = new MyStack<Integer>();
		// Add 10 int to Stack
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		// Show iterated Stack
		for (Integer integer : stack) {
			System.out.print(integer);
		}
		
		
		// Create Consulta
		Consulta consulta = new Consulta();
		// Create 3 Pacientes
		Paciente juanjo = new Paciente("Juanjo", consulta);
		Paciente pedro = new Paciente("Pedro", consulta);
		Paciente alberto = new Paciente("Alberto", consulta);
		// Add Pacientes to Consulta
		consulta.Register(juanjo);
		consulta.Register(pedro);
		consulta.Register(alberto);
		// Notify Pacientes
		System.out.println("\n\nObserber Test");
		consulta.NotifyObserver("Juanjo");
		consulta.NotifyObserver("Pedro");
		consulta.NotifyObserver("Alberto");
		consulta.NotifyObserver("Juanjo");
		consulta.NotifyObserver("Pedro");
		consulta.NotifyObserver("Alberto");
		
		
		System.out.println("\n\nEventManager Test");
		// Create EventManger
		EventManager eventManager = new EventManager();
		// Create 2 Pacientes
		Perros juanma = new Perros("Farola1");
		Perros jorge = new Perros("Farola2");
		
		juanma.AddEvent("Farola2");
		
		eventManager.RegisterObserver("Farola1", juanma);
		eventManager.RegisterObserver("Farola2", juanma);
		eventManager.RegisterObserver("Farola2", jorge);
		
		eventManager.NotifyObservers("Farola1");
		eventManager.NotifyObservers("Farola2");
	}
}
// habra algo que tenga una lista, lista tiene que ser comparable o puede ser que una cosa se itere con una cosa rara, lista que se tiene que ordenar
