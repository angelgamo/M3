package Factoria;

public interface PoolFactory<T> {
	public T create();
	public void destroy(T element);
}
