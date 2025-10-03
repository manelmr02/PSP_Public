package EjercicioRefugioAnimales;

public class Animal {
	String nombre;
	int edad;
	
	public Animal(String nombre, int edad) {
		this.nombre=nombre;
		this.edad=edad;
	}
	
	public void mostrarDatos() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	
	
}
