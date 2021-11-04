package Factoria;

public class FactoryNoNadadores implements PoolFactory {
	
	private int count = 0;

	@Override
	public Object create() {
		NoNadadores element = new NoNadadores("NoNadador"+count);
		count++;
		return element;
	}

	@Override
	public void destroy(Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "FactoryNoNadadores [count=" + count + "]";
	}

}
