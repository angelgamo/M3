
public class Paciente implements Observer {
	String name;
	Consulta consulta;
	
	public Paciente(String name, Consulta consulta) {
		this.name = name;
		this.consulta = consulta;
	}

	@Override
	public void update(String name) {
		if (this.name.equals(name)) {
			System.out.println(this + " me toca");
			this.consulta.Unregister(this);
		}
	}

	@Override
	public String toString() {
		return name;
	}
}
