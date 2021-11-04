
import java.util.ArrayList;
import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {
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
	
	private class MyIterator<T> implements Iterator<T> {
		int index = stack.size(); 

	    public boolean hasNext() {
		    if ((index - 1) >= 0)
		    	return true;
		    return false;
	    }

	    public T next() {
	    	index--;
	        return (T) stack.get(index);
	    }

	    public void remove() {
	    }
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>();
	}
}
