package EjercicioRefugioAnimales;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		System.out.println("Bienvenido al menu del refugio de animales.");
		int opcion=3, tipo=0;
		Scanner sc=new Scanner(System.in);
		ArrayList<Animal> animal=new ArrayList<Animal>();
		do {
			System.out.println("1.- AÑADIR ANIMAL");
			System.out.println("2.- MOSTRAR DATOS DE TODOS LOS ANIMALES DEL REFUGIO");
			System.out.println("0.- SALIR");
			System.out.println("Selecciona una opción:");
			opcion=sc.nextInt();
			if(opcion==1) {
				sc.nextLine();
				String nombre;
				int edad;
				System.out.println("Introduzca los datos del animal:");
				System.out.println("Nombre:");
				nombre=sc.nextLine();
				System.out.println("Edad:");
				edad=sc.nextInt();
				System.out.println("Seleccione el tipo de animal que desea añadir:");
				System.out.println("1.- GATO");
				System.out.println("2.- PERRO");
				tipo=sc.nextInt();
				if(tipo==1) {
					int longitud;
					System.out.println("Longitud de los bigotes:");
					longitud=sc.nextInt();
					System.out.println("Añadiendo gato...");
					animal.add(new Gato(nombre,edad,longitud));
				}else if(tipo==2) {
					sc.nextLine();
					String raza;
					System.out.println("Raza:");
					raza=sc.nextLine();
					System.out.println("Añadiendo perro...");
					animal.add(new Perro(nombre,edad,raza));
				}	
			}else if(opcion==2){
				for(int i=0;i<animal.size();i++) {
					animal.get(i).mostrarDatos();
				}
			}
		}while(opcion!=0);	
		System.out.println("SALIENDO...");
		sc.close();
	}
}
