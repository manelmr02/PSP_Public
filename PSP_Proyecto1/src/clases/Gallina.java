package clases;

import java.util.Random;

public class Gallina extends Animal{

	public Gallina(String nombre, int velocidad) {
		
		super(nombre, velocidad);
	}
	
	@Override
	public void run() {
		while(true) {
			correr();
			try {
				Thread.sleep(1000);// para que descanse 4 turnos mas es decir 4 segundos mas que el resto
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void correr() {
		Random random=new Random();
		int numeroR=random.nextInt(1,4);
		if(numeroR==1) {
			super.correr();
		}else if(numeroR==2) {
			System.out.println("La gallina esta poniendo un huevo.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			this.distancia+=15;
			this.decirPosicion();
		}
	}

}
