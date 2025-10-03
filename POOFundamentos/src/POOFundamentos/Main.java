package POOFundamentos;

public class Main {
	
	static int edad;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//edad=0;
		//saludar();
		
		Moto m1=new Moto("azul");
		Moto.setDescripcion("A");
		Moto m2=new Moto("verde");
		System.out.println(m1.getColor());
		System.out.println(m2.getColor());
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(Moto.getDescripcion());
		System.out.println("------------------------");
		System.out.println("Cambio de descripcion...");
		System.out.println("------------------------");
		Moto.setDescripcion("Prueba");
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(Moto.getDescripcion());

		
		
		
		
	}
	
	static void saludar() {
		System.out.println("Hola");
		
	}

}
