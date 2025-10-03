package EjercicioRefugioAnimales;

public class Gato extends Animal{

	int tamanioBigotes;
	
	public Gato(String nombre,int edad, int bigotes) {
		super(nombre,edad);
		this.tamanioBigotes=bigotes;
	}
	
	public void maullar() {
		System.out.println("Miau Miau");
	}
	
	@Override
	public String toString() {
		return "Gato de nombre: "+this.nombre+" , edad: "+this.edad+" y tamaño de bigotes "+this.tamanioBigotes+"mm";
	}

}
