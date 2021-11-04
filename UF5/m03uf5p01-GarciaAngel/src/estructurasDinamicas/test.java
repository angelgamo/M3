package estructurasDinamicas;
import java.util.ArrayList;

import Factoria.FactoryNoNadadores;
import Factoria.NoNadadores;
import Factoria.Pool;

public class test {
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<Integer>();
		MyQueue<Integer> queue = new MyQueue<Integer>();
		MyPool pool = new MyPool();
		
		
		// add 10 items
		for (int i = 0; i < 10; i++) {
			stack.push(i);
			queue.push(i);
		}
		
		// show list content
		System.out.println("Initial values");
		System.out.println("Stack looks like this " + stack);
		System.out.println("Queue looks like this " + queue);
		System.out.println("Pool looks like this " + pool);
		
		
		ArrayList<Integer> poped = new ArrayList<Integer>();
		// pop 11 items
		System.out.println("\npop 11 items");
		for (int i = 0; i < 11; i++) {
			try {
				System.out.print("Stack " + stack.pop());
			} catch (MyException e1) {
				e1.printStackTrace();
			}
			try {
				System.out.print(" Queue " + queue.pop());
			} catch (MyException e) {
				e.printStackTrace();
			}
			try {
				Integer get = pool.get();
				poped.add(get);
				System.out.println(" Pool " + get);
				
			} catch (MyException e) {
				e.printStackTrace();
			}
		}
		
		// show list content
		System.out.println("\nshow values");
		System.out.println("Stack looks like this " + stack);
		System.out.println("Queue looks like this " + queue);
		System.out.println("Pool looks like this " + pool);
		
		// add 5 items
		System.out.println("\nadd 5 items");
		for (int i = 0; i < 5; i++) {
			stack.push(i);
			queue.push(i);
			pool.returnInteger(poped.remove(0));
		}
		
		// show list content
		System.out.println("\nshow values");
		System.out.println("Stack looks like this " + stack);
		System.out.println("Queue looks like this " + queue);
		System.out.println("Pool looks like this " + pool);
		
		// pop 6 items
		System.out.println("\npop 6 items");
		for (int i = 0; i < 6; i++) {
			try {
				System.out.print("Stack " + stack.pop());
			} catch (MyException e1) {
				e1.printStackTrace();
			}
			try {
				System.out.print(" Queue " + queue.pop());
			} catch (MyException e) {
				e.printStackTrace();
			}
			try {
				Integer get = pool.get();
				poped.add(get);
				System.out.println(" Pool " + get);
				
			} catch (MyException e) {
				e.printStackTrace();
			}
		}
		
		// show list content
		System.out.println("\nshow values");
		System.out.println("Stack looks like this " + stack);
		System.out.println("Queue looks like this " + queue);
		System.out.println("Pool looks like this " + pool);
		
		
		// factory and poolfactory creation
		FactoryNoNadadores factoria = new FactoryNoNadadores();
		Pool<NoNadadores> poolfact = new Pool<NoNadadores>(factoria);
		
		// show poolfactory
		System.out.println("\n\nShow Pool Factory");
		System.out.println(poolfact);
		
		// get element and show element, poolfactory
		System.out.println("\nGet element and show element, Pool Factory");
		NoNadadores element;
		try {
			element = poolfact.get();
		} catch (MyException e) {
			e.printStackTrace();
			element = null;
		}		
		System.out.println(element);
		System.out.println(poolfact);
		
		// return element and show poolfactory
		System.out.println("\nReturn element and show Pool Factory");
		try {
			poolfact.returnElement(element);
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		// return same element and show poolfactory
		System.out.println("\nReturn SAME element and show Pool Factory");
		try {
			poolfact.returnElement(element);
		} catch (MyException e) {
			e.printStackTrace();
		}
		System.out.println(poolfact);
		
		// get 10 elements and show poolfactory
		System.out.println("\nGet 10 elements and Show");
		ArrayList<NoNadadores> getted = new ArrayList<NoNadadores>();
		for (int i = 0; i < 10; i++) {

			try {
				getted.add(poolfact.get());
			} catch (MyException e) {
				e.printStackTrace();
			}

		}
		System.out.println(poolfact);
		
		// get another one
		System.out.println("\nGet the 11nd");
		try {
			getted.add(poolfact.get());
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		// create a new nonadador and try return it
		System.out.println("\nReturn non existing in list NoNadador");
		NoNadadores nadador = new NoNadadores("nuevo");
		try {
			poolfact.returnElement(nadador);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}
