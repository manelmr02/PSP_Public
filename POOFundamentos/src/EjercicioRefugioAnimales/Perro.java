package EjercicioRefugioAnimales;

public class Perro extends Animal{

	String raza;
	
	public Perro(String nombre,int edad, String raza) {
		super(nombre,edad);
		this.raza=raza;
	}
	
	public void ladrar() {
		System.out.println("Guau Guau");
	}
	
	@Override
	public String toString() {
		return "Perro de nombre: "+this.nombre+" , edad: "+this.edad+" y raza "+this.raza;
	}

}
