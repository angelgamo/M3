
import java.util.ArrayList;
import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {
	ArrayList<T> queue = new ArrayList<T>();
	
	public void push(T obj) {
		this.queue.add(obj);
	}
	
	public T pop() throws MyException {
		try{
			return this.queue.remove(0);
		}catch(IndexOutOfBoundsException e) {
			throw new MyException("No hi han mes objectes dins de Queue");
		}
	}
	
	public String toString() {
		return this.queue.toString();
	}
	
	@Override
	public Iterator<T> iterator() {
		return queue.iterator();
	}
}
