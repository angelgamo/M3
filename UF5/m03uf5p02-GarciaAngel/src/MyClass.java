
public class MyClass implements Comparable<MyClass> {
	String nombre;
	int edad;
	String nombreMascota;
	
	public MyClass(String nombre, int edad, String nombreMascota) {
		this.nombre = nombre;
		this.edad = edad;
		this.nombreMascota = nombreMascota;
	}
	
	
	@Override
	public int compareTo(MyClass o) {
		int valorNombre = nombre.compareTo(o.nombre);

		if (valorNombre < 0) {
			return -1;
		}else if(valorNombre > 0) {
			return 1;
		}else {
			if (edad > o.edad) {
				return -1;
			}else if(edad < o.edad) {
				return 1;
			}else {
				int valorMascota = nombreMascota.compareTo(o.nombreMascota);
				
				if (valorMascota < 0) {
					return -1;
				}else if (valorMascota > 0){
					return 1;
				} else {
					return 0;
				}
			}
		}
	}


	@Override
	public String toString() {
		return "MyClass [nombre=" + nombre + ", edad=" + edad + ", nombreMascota=" + nombreMascota + "]";
	}
	
	
}
