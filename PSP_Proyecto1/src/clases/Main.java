package clases;

public class Main {

	public static void main(String[] args) {
		
		/*Animal a1=new Animal("Caballo",5);
		Animal a2=new Animal("Gallina",3);
		Animal a3=new Animal("Tortuga",1);
		
		
		System.out.println("Comienza la carrera de prueba!!");
		System.out.println("-------------------------------");
		System.out.println("Posicion del Caballo: ");
		a1.decirPosicion();
		System.out.println("Posicion de la Gallina: ");
		a2.decirPosicion();
		System.out.println("Posicion de la Tortuga: ");
		a3.decirPosicion();
		
		System.out.println("-------------------------------");
		System.out.println("CORREN DURANTE TRES SEGUNDOS...");
		System.out.println("-------------------------------");
		
		a1.correr();
		a1.correr();
		a1.correr();
		a2.correr();
		a2.correr();
		a2.correr();
		a3.correr();
		a3.correr();
		a3.correr();
		
		System.out.println("Posicion del Caballo: ");
		a1.decirPosicion();
		System.out.println("Posicion de la Gallina: ");
		a2.decirPosicion();
		System.out.println("Posicion de la Tortuga: ");
		a3.decirPosicion();
		*/
		
		
		System.out.println("--------------------------------");
		System.out.println("| PASAMOS A EJECUTAR POR HILOS |");
		System.out.println("--------------------------------");
		
		Animal liebre=new Liebre("Liebre",10);// avanza durante4 turnos y descansa durante 8
		Animal gallina=new Gallina("Gallina",3);// de forma random corre (+3), vuela (+15) o pone un huevo (+0)
		Animal tortuga=new Tortuga("Tortuga",1);// avanza siempre para alante
		
		Thread hiloLiebre= new Thread(liebre);//creamos un hilo en el que se va a ejecutar el animal que introduzcamos, concretamente se ejecuta lo que tenemos en el run() del Animal.
		Thread hiloGallina= new Thread(gallina);
		Thread hiloTortuga= new Thread(tortuga);
		hiloLiebre.start();// con esto comienza a ejecutarse el hilo
		hiloTortuga.start();
		hiloGallina.start();
	}

}
