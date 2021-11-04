package Factoria;

import java.util.ArrayList;

import estructurasDinamicas.MyException;

public class Pool<T> {
	ArrayList<T> listUsed;
	ArrayList<T> listDisponible;
	
	PoolFactory<T> m_factory;
	
	public Pool(PoolFactory<T> factory) {
		listUsed = new ArrayList<T>();
		listDisponible = new ArrayList<T>();
		m_factory = factory;
		for (int i = 0; i < 10; i++) {
			T element = m_factory.create();
			listDisponible.add(element);
		}
	}
	
	public T get() throws MyException {
		if (listDisponible.size() == 0) {
			throw new MyException("No hay ningun elemento en el pool");
		}
		T element = listDisponible.remove(0);
		listUsed.add(element);
		return element;
	}
	
	public void returnElement(T element) throws MyException{
		if (listUsed.contains(element)) {
			T used = listUsed.remove(listUsed.indexOf(element));
			listDisponible.add(used);
		}else {
			throw new MyException("El elemento no esta en uso");
		}
	}

	@Override
	public String toString() {
		return "Pool [listUsed=" + listUsed + ", listDisponible=" + listDisponible + ", m_factory=" + m_factory + "]";
	}
}
