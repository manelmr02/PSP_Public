package POOFundamentos;

public class Moto {
	
	static String descripcion;
	String color;
	
	public Moto(String color) {
		this.color = color;
	}


	public void pintar(String color) {
		this.color=color;
	}

	static void escribirDescripcion() {
		System.out.println(descripcion);
	}

	public static String getDescripcion() {
		return descripcion;
	}


	public static void setDescripcion(String descripcion) {
		Moto.descripcion = descripcion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Moto [color=" + color +" descripcion="+descripcion +"]";
	}
	
	
}
