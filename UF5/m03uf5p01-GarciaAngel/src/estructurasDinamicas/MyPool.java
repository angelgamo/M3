package estructurasDinamicas;
import java.util.ArrayList;

public class MyPool {
	
	ArrayList<Integer> listUsed = new ArrayList<Integer>();
	ArrayList<Integer> listDisponible = new ArrayList<Integer>();
	
	public MyPool(){
		ArrayList<Integer> IntegerList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			int num = i;
			IntegerList.add(num);
		}
		this.listDisponible = IntegerList;
	}

	public Integer get() throws MyException {
		if (listDisponible.size() == 0) {
			throw new MyException("No hay ningun objeto");
		}
		Integer num = this.listDisponible.remove(0);
		listUsed.add(num);
		return num;
	}
	
	public boolean returnInteger(Integer num) {
		if(listUsed.contains(num)) {
			Integer used = listUsed.get(listUsed.indexOf(num));
			listDisponible.add(used);
			listUsed.remove(used);
			return true;
		}
		return false;
	}
	
	public String toString() {
		return this.listDisponible.toString();
	}
	
}
