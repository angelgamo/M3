package estructurasDinamicas;
import java.util.ArrayList;

public class MyStack<T> {
	ArrayList<T> stack = new ArrayList<T>();
	
	public void push(T obj) {
		this.stack.add(obj);
	}
	
	public T pop() throws MyException {
		try{
			return this.stack.remove(this.stack.size()-1);
		}catch(IndexOutOfBoundsException e) {
			throw new MyException("No hi han mes objectes dins de Stack");
		}
	}
	
	public String toString() {
		return this.stack.toString();
	}
}
