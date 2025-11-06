package Clases;

import java.util.concurrent.Semaphore;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Comienza la carrera!!!!");
		Semaphore s=new Semaphore(1);//1 porque solo una tortuga puede pasar
		Tortuga t1=new Tortuga("Donatello",s);
		Tortuga t2=new Tortuga("Rafaelle",s);
		Tortuga t3=new Tortuga("Leonardo",s);
		t1.start();
		t2.start();
		t3.start();

	}

}
