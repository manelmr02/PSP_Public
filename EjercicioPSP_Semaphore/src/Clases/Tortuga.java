package Clases;

import java.util.concurrent.Semaphore;

public class Tortuga extends Thread{
	
	private String nombre;
	private Semaphore tunel;

	public Tortuga(String nombre,Semaphore tunel) {
		this.nombre=nombre;
		this.tunel=tunel;
	}
	
	//vamos a tener en cuenta que solo avanzan un metro por segundo, siempre, a velocidad constante
	@Override
	public void run() {
		 try {
	            int i = 1;// variable para utilizar en los bucles

	            // primeros 5 metros
	            for (; i < 5; i++) {
	                System.out.println(nombre + " avanza " + i + " metros...");
	                Thread.sleep(200);
	            }

	            // entrada al tunel y intenta entrar
	            System.out.println(nombre + " llegó al túnel (metro 5) y quiere entrar...");
	            tunel.acquire();
	            System.out.println(nombre + " ENTRA al túnel...");

	            // Avanza dentro del túnel (metro 5 al 15)
	            for (; i < 15; i++) {
	                System.out.println(nombre + " está en el túnel (" + i + "m)...");
	                Thread.sleep(300);
	            }

	            // salida del tunel
	            System.out.println(nombre + " SALE del túnel (metro 15).");
	            tunel.release();

	            // avanza los ultimos 5 metros
	            for (; i <= 20; i++) {
	                System.out.println(nombre + " avanza " + i + " metros...");
	                Thread.sleep(200);
	            }

	            System.out.println(nombre + " ha llegado a la meta!");
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
    }


}
